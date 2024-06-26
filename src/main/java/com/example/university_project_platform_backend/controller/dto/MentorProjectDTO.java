package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MentorProjectDTO extends Project   {
    private Long mentorId;
    private String mentorName;

    private Long competitionId;
    private String competitionName;

    private Long groupId;
    private String groupName;
}
