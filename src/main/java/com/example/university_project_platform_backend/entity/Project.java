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
 * @since 2024-04-21
 */
@Getter
@Setter
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    private Long projectId;

    /**
     * 项目姓名
     */
    private String projectName;

    /**
     * 项目图片连接
     */
    private String projectImage;

    /**
     * 项目简介
     */
    private String projectIntroduction;

    /**
     * 项目优势
     */
    private String projectAdvantage;

    /**
     * 项目学分
     */
    private Integer projectCredits;

    /**
     * 项目创建时间
     */
    private LocalDateTime projectCreateTime;

    /**
     * 项目结束时间
     */
    private LocalDateTime projectEndTime;

    /**
     * 项目立项材料
     */
    private String projectProposalLink;

    /**
     * 老师ID
     */
    private Long mentorId;

    /**
     * 项目范围
     */
    private String projectScope;

    /**
     * 项目标签(科研项目0 竞赛项目1)
     */
    private Byte projectTag;

    /**
     * 项目归属地
     */
    private String projectBelong;

    /**
     * 项目完成状态:未开始0 进行中1 已结束2 操作失败3
     */
    private Byte projectDoneStatus;

    /**
     * 项目完成时间
     */
    private LocalDateTime projectDoneTime;

    /**
     * 项目完成状态描述
     */
    private String projectDoneDescription;

    /**
     * 项目等级,数字越高等级越高,0为没有等级
     */
    private Integer projectLevel;
}
