package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.StudentAudit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAuditWithNameDTO extends StudentAudit {
    private Long mentorId;
    private String mentorName;

    private Long competitionId;
    private String competitionName;

    private Long groupId;
    private String groupName;

    private Long studentId;
    private String studentName;

    private Long projectId;
    private String projectName;
}
