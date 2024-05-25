package com.example.university_project_platform_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 竞赛处id
     */
    @TableId(value = "Competition_id", type = IdType.AUTO)
    private Long competitionId;

    /**
     * 竞赛处名字
     */
    private String competitionName;

    /**
     * 所属学院
     */
    private String competitionFrom;
}
