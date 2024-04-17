package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.common.CreditsStudentDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-30
 */
public interface CreditsMapper extends BaseMapper<Credits> {
    List<CreditsStudentDTO> getCreditsWithStudent(Long studentId);

    List<CreditsStudentDTO> getCredits();
}
