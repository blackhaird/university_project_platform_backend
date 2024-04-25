package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Credits;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreditsStudentDTO extends Credits {
    private String studentName;
    private int studentAge;
    private String studentPhoneNumber;
    private String studentClass;
}
