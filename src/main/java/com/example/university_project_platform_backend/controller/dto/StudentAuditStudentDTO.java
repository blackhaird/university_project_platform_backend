package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.StudentAudit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StudentAuditStudentDTO extends StudentAudit {
    private List<Long> studentIdList;
}
