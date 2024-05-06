package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.university_project_platform_backend.controller.dto.CreditsAuditWithNameDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.CreditsAudit;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.mapper.CreditsAuditMapper;
import com.example.university_project_platform_backend.service.ICreditsAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.university_project_platform_backend.service.ICreditsOperationService;
import com.example.university_project_platform_backend.service.ICreditsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
@Service
public class CreditsAuditServiceImpl extends ServiceImpl<CreditsAuditMapper, CreditsAudit> implements ICreditsAuditService {
    @Autowired
    private ICreditsService iCreditsService;
    @Autowired
    private ICreditsOperationService iCreditsOperationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> creditsAuditSubmit(ProjectManagement projectManagement) {
        Map<String, Object> creditsAuditMap = new HashMap<>();
        List<CreditsAudit> credits = this.baseMapper.getCreditsFormTable(projectManagement);

        try {
            for (int i = 0; i < credits.size(); i++) {
                CreditsAudit credit = credits.get(i);
                credit.setCreditsAuditStatus((byte) 2);
                this.save(credit);
            }
        } catch (Exception e) {
            log.error("提交项目管理失败，已回滚事务", e);
            creditsAuditMap.put("message", "提交学分审查失败，已回滚事务");
        }
        creditsAuditMap.put("data", credits);
        return creditsAuditMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> creditsAuditUpdate(CreditsAudit creditsAudit) {
        Map<String, Object> map = new HashMap<>();
        try {
            //将学分审核状态更新
            LambdaUpdateWrapper<CreditsAudit> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId());
            wrapper.eq(CreditsAudit::getProjectId, creditsAudit.getProjectId());
            wrapper.eq(CreditsAudit::getStudentId, creditsAudit.getStudentId());
            boolean rowsAffected = this.update(creditsAudit, wrapper);

            //查询更新的学生状态
            LambdaQueryWrapper<CreditsAudit> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId())
                    .eq(CreditsAudit::getProjectId, creditsAudit.getProjectId())
                    .eq(CreditsAudit::getStudentId, creditsAudit.getStudentId());
            CreditsAudit originalCreditsAudit = this.getOne(queryWrapper);
            System.out.println("rowsAffected：" + rowsAffected);

            //查询插入状态验证情况
            if (rowsAffected) {
                //若需要运行改学分审核成功
                if (creditsAudit.getCreditsAuditStatus() == 1) {
                    LambdaQueryWrapper<Credits> wrapperCredits = new LambdaQueryWrapper<>();
                    wrapperCredits.eq(Credits::getStudentId, creditsAudit.getStudentId());
                    Credits credits = iCreditsService.getOne(wrapperCredits);
                    int credits_now = credits.getCreditsValue();
                    System.out.println("credits_now:"+credits_now);
                    int credits_after = credits.getCreditsValue() + originalCreditsAudit.getProjectCredits();
                    credits.setCreditsValue(credits_after);
                    iCreditsService.updateById(credits);
                    System.out.println("success");

                    map.put("message", "[" + credits.getCreditsId() + "] 的学分更新更新成功 :" + credits_now + " + " + originalCreditsAudit.getProjectCredits());

                    LambdaQueryWrapper<CreditsAudit> wrapper2 = new LambdaQueryWrapper<>();
                    wrapper2.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId());
                    wrapper2.eq(CreditsAudit::getProjectId, creditsAudit.getProjectId());
                    wrapper2.eq(CreditsAudit::getStudentId, creditsAudit.getStudentId());
                    List<CreditsAudit> creditsAuditList = this.list(wrapper2);
                    map.put("data", creditsAuditList);
                }else {
                    map.put("message", "已经拒绝 [" + creditsAudit.getStudentId() + "] 的学分更新 :" );
                }
            } else {
                map.put("message", "更新失败");
            }
        } catch (Exception e) {
            log.error("更新学分审核状态失败，已回滚事务", e);
            map.put("message", "更新学分审核状态失败，已回滚事务");
        }
        return map;
    }

    @Override
    public Map<String, Object> creditsAuditShowByCompetitionId(CreditsAudit creditsAudit) {
        Map<String, Object> map = new HashMap<>();
//        LambdaQueryWrapper<CreditsAudit> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId());
//        List<CreditsAudit> creditsAuditList = this.list(wrapper);
        List<CreditsAuditWithNameDTO> creditsAuditList = this.baseMapper.getCreditsWithNameFormTable(creditsAudit);
        if (creditsAuditList.size() != 0) {
            map.put("data", creditsAuditList);
        } else {
            map.put("message", "未查询到数据");
        }
        return map;
    }
}
