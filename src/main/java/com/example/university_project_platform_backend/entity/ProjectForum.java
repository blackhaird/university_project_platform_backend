package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2024-04-19
 */
@Getter
@Setter
@TableName("project_forum")
public class ProjectForum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_Forum_id", type = IdType.AUTO)
    private Integer projectForumId;

    private Long userId;

    private String foruserId;

    private String projectForumMessage;

    private String projectForumFile;

    private LocalDateTime projectForumTime;
}
