package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.ProjectManagement;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface IProjectService extends IService<Project> {

    Map<String, Object> projectUpdateByProjectCreator(Long ProjectCreatorId, Project project);

    boolean projectDeleteByProjectCreator(Long mentorId, Long projectId);

    Map<String, Object> projectSearchByProject(Project project);

    Map<String, Object> getProjectNew();

    Map<String,Object> getStudentsProjectByStudentId(Long studentId);

    Map<String, Object> getProjectWithStudentMentorData();

    Map<String, Object> getStudentsProjectByMentorId(Long studentId);

    boolean projectAddByMentorId(Long mentorId, Project project);

    Map<String, Object> projectSearchByProjectNameFuzzy(Project project);

    Map<String, Object> getProjectSearchWithStudentMentorData(ProjectAddDataDTO projectAddDataDTO);

    boolean projectDone(ProjectManagement projectManagement,int status);

    Map<String, Object> getProjectLevelTop5();

    List<ProjectAddDataDTO> projectShowWithData();

    boolean projectUpdateDoneStatus(Project project);
}
