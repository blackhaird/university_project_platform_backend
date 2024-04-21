package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.StudentGroupProjectManagementDTO;
import com.example.university_project_platform_backend.entity.StudentAudit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.StudentGroup;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
public interface IStudentAuditService extends IService<StudentAudit> {

    Map<String, Object> studentAuditSubmit(StudentGroupProjectManagementDTO studentGroupProjectManagementDTO);

    Boolean studentAuditUpdate(StudentAudit studentAudit);

    Map<String, Object> studentAuditSearch(StudentAudit studentAudit);

    Map<String, Object> getStudentAuditByMentorId(StudentAudit studentAudit);
}
