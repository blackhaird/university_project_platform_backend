package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author blackhaird
 * @since 2024-05-26
 */
@Getter
@Setter
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动图片连接
     */
    private String activityImage;

    /**
     * 活动简介
     */
    private String activityIntroduction;

    /**
     * 活动创建时间
     */
    private LocalDateTime activityCreateTime;

    /**
     * 活动结束时间
     */
    private LocalDateTime activityEndTime;

    /**
     * 竞赛处ID
     */
    private Long competitionId;

    /**
     * 活动范围
     */
    private String activityScope;

    /**
     * 活动完成状态:进行中1,已结束2
     */
    private Byte projectDoneStatus;
}
