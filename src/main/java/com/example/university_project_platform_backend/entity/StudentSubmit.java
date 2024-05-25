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
 * @since 2024-05-26
 */
@Getter
@Setter
@TableName("student_submit")
public class StudentSubmit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "student_submit_id", type = IdType.AUTO)
    private Integer studentSubmitId;

    /**
     * studentID
     */
    private Long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 学生技能
     */
    private String studentSkill;

    /**
     * 学生经验
     */
    private String studentExper;
}
