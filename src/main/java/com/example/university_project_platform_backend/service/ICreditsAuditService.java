package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.entity.CreditsAudit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.ProjectManagement;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
public interface ICreditsAuditService extends IService<CreditsAudit> {


    Map<String,Object> creditsAuditSubmit(ProjectManagement projectManagement);

    Map<String, Object> creditsAuditUpdate(CreditsAudit creditsAudit);

    Map<String, Object> creditsAuditShowByCompetitionId(CreditsAudit creditsAudit);
}
