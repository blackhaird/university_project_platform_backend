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
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mail_id", type = IdType.AUTO)
    private Integer mailId;

    private Long userId;

    private String foruserId;

    private Long groupId;

    private String mailMessage;

    private String mailFile;

    private LocalDateTime mailTime;
}
