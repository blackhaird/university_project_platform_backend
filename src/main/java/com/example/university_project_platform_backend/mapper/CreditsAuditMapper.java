package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.controller.dto.CreditsAuditWithNameDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.CreditsAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.university_project_platform_backend.entity.ProjectManagement;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
public interface CreditsAuditMapper extends BaseMapper<CreditsAudit> {


    List<CreditsAudit> getCreditsFormTable(ProjectManagement projectManagement);

    List<CreditsAuditWithNameDTO> getCreditsWithNameFormTable(CreditsAudit creditsAudit);
}
