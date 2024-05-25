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
 * @since 2024-05-26
 */
@Getter
@Setter
@TableName("credits_audit")
public class CreditsAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "credits_audit_id", type = IdType.AUTO)
    private Integer creditsAuditId;

    /**
     * studentID
     */
    private Long studentId;

    /**
     * 老师id
     */
    private Long mentorId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 加入的学生组id
     */
    private Long groupId;

    /**
     * 竞赛处id
     */
    private Long competitionId;

    private Integer projectCredits;

    /**
     * 0:操作失败 1：操作成功 2：审核中
     */
    private Byte creditsAuditStatus;

    /**
     * 审核状态描述 注释/备注
     */
    private String creditsAuditStatusDescription;

    private LocalDateTime creditsAuditTime;
}
