package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class StudentMentorDTO extends Student {
    private Long mentorId;

    private String mentorName;
}
