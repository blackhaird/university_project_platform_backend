package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.university_project_platform_backend.controller.dto.StudentGroupProjectManagementDTO;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.entity.StudentAudit;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.mapper.StudentAuditMapper;
import com.example.university_project_platform_backend.service.IStudentAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class StudentAuditServiceImpl extends ServiceImpl<StudentAuditMapper, StudentAudit> implements IStudentAuditService {

    @Override
    public Map<String, Object> studentAuditSubmit(StudentGroupProjectManagementDTO studentGroupProjectManagementDTO) {
        Map<String, Object> map = new HashMap<>();
        StudentAudit studentAudit = new StudentAudit();
        studentAudit.setStudentId(studentGroupProjectManagementDTO.getGroupStudentId());
        studentAudit.setProjectId(studentGroupProjectManagementDTO.getProjectId());
        studentAudit.setGroupId(studentGroupProjectManagementDTO.getGroupId());
        studentAudit.setMentorId(studentGroupProjectManagementDTO.getGroupMentorId());
        studentAudit.setStudentAuditStatus((byte) 2);
        if (studentAudit.getStudentId() != null && studentAudit.getProjectId() != null && studentAudit.getGroupId() != null && studentAudit.getMentorId() != null) {
            List<StudentAudit> studentAuditIsExist = this.baseMapper.studentAuditIsExist(studentAudit, 1);
            List<StudentAudit> studentAuditIsSubmit = this.baseMapper.studentAuditIsExist(studentAudit, 2);

            if (studentAuditIsExist.isEmpty() && studentAuditIsSubmit.isEmpty()) {
                boolean flag = this.save(studentAudit);
                if (flag) {
                    map.put("message", "申请成功，等待老师审核");
                    map.put("data", studentAudit);

                } else {
                    map.put("message", "申请失败，请检查数据");
                    log.error("/studentAuditSubmit error");
                }
            } else if (!studentAuditIsSubmit.isEmpty()) {
                map.put("message", "你已经提交过该申请，请等待老师审核");
            } else if (!studentAuditIsExist.isEmpty()) {
                map.put("message", "查找到您的通过记录，您已经是该小组的成员，无需重复申请");
            } else {
                map.put("message", "未知错误");
            }
        }else {
            map.put("message", "数据不全,或者字段有误");
        }
        return map;
    }

    @Override
    public Boolean studentAuditUpdate(StudentAudit studentAudit) {
        boolean flag ;
        List<StudentAudit> studentAuditIsSubmit = this.baseMapper.studentAuditIsExist(studentAudit, 2);
        if (!studentAuditIsSubmit.isEmpty()) {
            LambdaUpdateWrapper<StudentAudit> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(StudentAudit::getStudentId, studentAudit.getStudentId());
            wrapper.eq(StudentAudit::getProjectId, studentAudit.getProjectId());
            wrapper.eq(StudentAudit::getGroupId, studentAudit.getGroupId());
            wrapper.eq(StudentAudit::getMentorId, studentAudit.getMentorId());
            wrapper.set(StudentAudit::getStudentAuditStatus, studentAudit.getStudentAuditStatus());
            wrapper.set(StudentAudit::getStudentAuditStatusDescription, studentAudit.getStudentAuditStatusDescription());
            this.update(wrapper);
            flag = true;
        } else {
            log.error("未找到对应学生审计记录");
            flag = false;
        }
        return flag;
    }
}
