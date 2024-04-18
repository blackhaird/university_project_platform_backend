package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("credits_audit")
public class CreditsAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "credits_audit_id", type = IdType.AUTO)
    private Integer creditsAuditId;

    /**
     * 学分记录表
     */
    private Integer creditsId;

    /**
     * 项目管理表
     */
    private Long projectManagementId;

    /**
     * 0:操作失败 1：操作成功 2：审核中
     */
    private Byte creditsAuditStatus;

    /**
     * 审核状态描述 注释/备注
     */
    private String creditsAuditStatusDescription;
}
