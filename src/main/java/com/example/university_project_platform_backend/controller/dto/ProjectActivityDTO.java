package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectActivityDTO extends Project {
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    private Long groupId;

    private String groupName;
    /**
     * 竞赛处ID
     */
    private Long competitionId;
    private Long competitionName;

    /**
     * 活动范围
     */
    private String activityScope;

    /**
     * 活动完成状态:进行中1,已结束2
     */
    private Byte projectDoneStatus;
}
