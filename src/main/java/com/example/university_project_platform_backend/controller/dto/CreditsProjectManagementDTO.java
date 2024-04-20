package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Credits;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditsProjectManagementDTO extends Credits {
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

    /**
     * 小组编号
     */
    private Long groupId;

    /**
     * 项目状态id 0代表未通过 1代表通过 2代表审核中
     */
    private Byte projectStatusId;

    /**
     * 项目状态状态描述 注释/备注
     */
    private String projectStatusDescription;
}
