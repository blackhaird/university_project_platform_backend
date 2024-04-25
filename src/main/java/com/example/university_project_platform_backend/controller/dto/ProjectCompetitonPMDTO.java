package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCompetitonPMDTO  extends Project {
    private Long competitionId;
    /**
     * 项目状态id 0代表未通过 1代表通过 2代表审核中
     */
    private Byte projectStatusId;

    /**
     * 项目状态状态描述 注释/备注
     */
    private String projectStatusDescription;

    /**
     * 导师姓名
     */
    private String mentorName;
}
