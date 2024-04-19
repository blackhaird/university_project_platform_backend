package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.StudentGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGroupProjectManagementDTO extends StudentGroup {

    /**
     * 项目编号
     */
    private Long projectId;

    /**
     * 导师编号
     */
    private Long mentorId;

    /**
     * 竞赛处id
     */
    private Long competitionId;

}
