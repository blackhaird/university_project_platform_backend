package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface ProjectMapper extends BaseMapper<Project> {
    List<ProjectAddDataDTO> getStudentsProjectByStudentId(Long studentId);

    List<ProjectAddDataDTO> getProjectWithStudentMentorData();

    List<ProjectAddDataDTO> getStudentsProjectByMentorId(Long mentorId);
}
