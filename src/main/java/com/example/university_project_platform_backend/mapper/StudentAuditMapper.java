package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.controller.dto.StudentGroupProjectManagementDTO;
import com.example.university_project_platform_backend.entity.StudentAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
public interface StudentAuditMapper extends BaseMapper<StudentAudit> {

    List<StudentAudit> studentAuditIsExist(StudentAudit studentAudit, int studentAuditStatus);
}
