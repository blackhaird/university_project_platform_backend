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
@TableName("student_group")
public class StudentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 小组自增id
     */
    @TableId(value = "group_number", type = IdType.AUTO)
    private Long groupNumber;

    /**
     * 小组id
     */
    private Long groupId;

    /**
     * 小组队名
     */
    private String groupName;

    /**
     * 创建老师ID
     */
    private Long groupMentorId;

    /**
     * 小组队长ID
     */
    private Long groupCaptainId;

    /**
     * 组员ID
     */
    private Long groupStudentId;

    /**
     * 小组创建时间
     */
    private LocalDateTime groupCreateTime;
}
