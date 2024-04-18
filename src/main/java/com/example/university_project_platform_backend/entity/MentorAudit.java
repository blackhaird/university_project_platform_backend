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
@TableName("mentor_audit")
public class MentorAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mentor_audit_id", type = IdType.AUTO)
    private Integer mentorAuditId;

    /**
     * 老师id
     */
    private Long mentorId;

    /**
     * 竞赛处id
     */
    private Long competitionId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 举行的学生组id
     */
    private Long groupId;

    /**
     * 0:操作失败 1：操作成功 2：审核中
     */
    private Byte mentorAuditStatus;

    /**
     * 审核状态描述 注释/备注
     */
    private String mentorAuditStatusDescription;
}
