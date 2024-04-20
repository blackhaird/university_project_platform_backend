package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.CreditsAudit;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.mapper.CreditsAuditMapper;
import com.example.university_project_platform_backend.service.ICreditsAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
@Service
public class CreditsAuditServiceImpl extends ServiceImpl<CreditsAuditMapper, CreditsAudit> implements ICreditsAuditService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> creditsAuditSubmit(ProjectManagement projectManagement) {
        Map<String,Object> creditsAuditMap = new HashMap<>();
         List<CreditsAudit> credits = this.baseMapper.getCreditsFormTable(projectManagement);

         try {
             for (int i = 0; i < credits.size(); i++) {
                 CreditsAudit credit = credits.get(i);
                 credit.setCreditsAuditStatus((byte)2);
                 this.save(credit);
             }
         }catch (Exception e) {
             log.error("提交项目管理失败，已回滚事务", e);
             creditsAuditMap.put("message", "提交学分审查失败，已回滚事务");
         }
         creditsAuditMap.put("data",credits);
         return creditsAuditMap;
    }

    @Override
    public Map<String, Object> creditsAuditUpdate(CreditsAudit creditsAudit) {
        Map<String, Object> map = new HashMap<>();
        LambdaUpdateWrapper<CreditsAudit> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId());
        wrapper.eq(CreditsAudit::getProjectId, creditsAudit.getProjectId());
        wrapper.eq(CreditsAudit::getStudentId, creditsAudit.getStudentId());
        wrapper.set(CreditsAudit::getCreditsAuditStatus, creditsAudit.getCreditsAuditStatus());
        wrapper.set(CreditsAudit::getCreditsAuditStatusDescription,creditsAudit.getCreditsAuditStatusDescription());
        boolean rowsAffected = this.update(creditsAudit, wrapper);
        if (rowsAffected) {
            LambdaQueryWrapper<CreditsAudit> wrapper2 = new LambdaQueryWrapper<>();
            wrapper2.eq(CreditsAudit::getCompetitionId, creditsAudit.getCompetitionId());
            wrapper2.eq(CreditsAudit::getProjectId, creditsAudit.getProjectId());
            wrapper2.eq(CreditsAudit::getStudentId, creditsAudit.getStudentId());
            List<CreditsAudit> creditsAuditList = this.list(wrapper2);
            map.put("data", creditsAuditList);
        }else {
            map.put("message", "更新失败");
        }
        return map;
    }
}
