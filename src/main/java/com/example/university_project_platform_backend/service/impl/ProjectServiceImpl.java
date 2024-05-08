package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.controller.dto.ProjectProjectManagementDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.mapper.ProjectMapper;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.example.university_project_platform_backend.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {


    @Override
    public Map<String, Object> projectUpdateByProjectCreator(Long ProjectCreatorId, Project project) {
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Project::getMentorId, ProjectCreatorId);
        wrapper.eq(Project::getProjectId, project.getProjectId());
        boolean projectFlag = this.update(project, wrapper);
        if (projectFlag) {
            Project projectList = this.getOne(wrapper);
            Map<String, Object> projectMap = new HashMap<>();
            projectMap.put("data", projectList);
            return projectMap;
        }
        return null;
    }

    @Override
    public boolean projectDeleteByProjectCreator(Long mentorId, Long projectId) {
        return false;
    }

    @Override
    public Map<String, Object> projectSearchByProject(Project project) {
        Map<String, Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        if (project.getProjectId() != null) {
            wrapper.eq(Project::getProjectId, project.getProjectId());
        }
        if (!StringUtils.isEmpty(project.getProjectName())) {
            wrapper.eq(Project::getProjectName, project.getProjectName());
        }
        if (project.getProjectCredits() != null) {
            wrapper.eq(Project::getProjectCredits, project.getProjectCredits());
        }
        if (project.getProjectCreateTime() != null) {
            wrapper.eq(Project::getProjectCreateTime, project.getProjectCreateTime());
        }
        if (project.getProjectEndTime() != null) {
            wrapper.eq(Project::getProjectEndTime, project.getProjectEndTime());
        }
        if (project.getMentorId() != null) {
            wrapper.eq(Project::getMentorId, project.getMentorId());
        }
        if (!StringUtils.isEmpty(project.getProjectScope())) {
            wrapper.eq(Project::getProjectScope, project.getProjectScope());
        }
        if (project.getProjectTag() != null) {
            wrapper.eq(Project::getProjectTag, project.getProjectTag());
        }
        if (!StringUtils.isEmpty(project.getProjectBelong())) {
            wrapper.eq(Project::getProjectBelong, project.getProjectBelong());
        }
        if (project.getProjectDoneStatus() != null) {
            wrapper.eq(Project::getProjectDoneStatus, project.getProjectDoneStatus());
        }
        if (project.getProjectDoneTime() != null) {
            wrapper.eq(Project::getProjectDoneTime, project.getProjectDoneTime());
        }
        if (!StringUtils.isEmpty(project.getProjectDoneDescription())) {
            wrapper.eq(Project::getProjectDoneDescription, project.getProjectDoneDescription());
        }
        if (project.getProjectLevel() != null) {
            wrapper.eq(Project::getProjectLevel, project.getProjectLevel());
        }
//        wrapper.or(i -> i
//                .eq(Project::getProjectId,project.getProjectId())
//                .eq(Project::getProjectName,project.getProjectName())
//                .eq(Project::getProjectCreator,project.getProjectCreator())
//                .eq(Project::getProjectScope,project.getProjectScope())
//                .eq(Project::getProjectTag,project.getProjectTag())
//                .eq(Project::getProjectBelong,project.getProjectBelong())
////                .eq(Project::getProjectProposalLink,project.getProjectProposalLink())
////                .eq(Project::getProjectEndTime,project.getProjectEndTime())
////                .eq(Project::getProjectCreateTime,project.getProjectCreateTime())
////                .eq(Project::getProjectIntroduction,project.getProjectIntroduction())
//        );

        List<Project> projectList = this.list(wrapper);
        if (!projectList.isEmpty()) {
            System.out.println("success");
            projectMap.put("data", projectList);
            return projectMap;
        } else {
            projectMap.put("message", "找不到筛选的数据");
            return projectMap;
        }
    }

    @Override
    public Map<String, Object> getProjectNew() {
        Map<String, Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.notIn(Project::getProjectDoneStatus, Arrays.asList(0, 3));
        wrapper.orderByDesc(Project::getProjectCreateTime).last("LIMIT 15");
        List<Project> top15Projects = this.baseMapper.selectList(wrapper);
        if (!top15Projects.isEmpty()) {
            projectMap.put("data", top15Projects);
        } else {
            return null;
        }
        return projectMap;
    }

    @Override
    public Map<String, Object> getStudentsProjectByStudentId(Long studentId) {

        Map<String, Object> studentMap = new HashMap<>();
        List<ProjectAddDataDTO> projectList = this.baseMapper.getStudentsProjectByStudentId(studentId);
        studentMap.put("data", projectList);
        return studentMap;
    }

    @Override
    public Map<String, Object> getProjectWithStudentMentorData() {
        Map<String, Object> projectMap = new HashMap<>();
        List<ProjectAddDataDTO> projectList = this.baseMapper.getProjectWithStudentMentorData();
        projectMap.put("data", projectList);
        return projectMap;
    }

    @Override
    public Map<String, Object> getStudentsProjectByMentorId(Long mentorId) {
        Map<String, Object> studentMap = new HashMap<>();
        List<ProjectAddDataDTO> projectList = this.baseMapper.getStudentsProjectByMentorId(mentorId);
        studentMap.put("data", projectList);
        return studentMap;
    }

    @Override
    public boolean projectAddByMentorId(Long mentorId, Project project) {

        boolean projectList = this.save(project);
        return projectList;
    }

    @Override
    public Map<String, Object> projectSearchByProjectNameFuzzy(Project project) {
        Map<String, Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Project::getProjectName,  project.getProjectName() );
        wrapper.ne(Project::getProjectDoneStatus, 0) // 排除status为0的项目
                .ne(Project::getProjectDoneStatus, 3); // 排除status为3的项目
        List<Project> projectList = this.baseMapper.selectList(wrapper);
        if (!projectList.isEmpty()) {
            projectMap.put("data", projectList);
            return projectMap;
        } else {
            projectMap.put("message", "找不到筛选的数据");
            return projectMap;
        }
    }

    @Override
    public Map<String, Object> getProjectSearchWithStudentMentorData(ProjectAddDataDTO projectAddDataDTO) {

        Map<String, Object> projectMap = new HashMap<>();
        List<ProjectAddDataDTO> projectList = this.baseMapper.getProjectSearchWithStudentMentorData(projectAddDataDTO);
        projectMap.put("data", projectList);
        return projectMap;
    }

    @Transactional
    @Override
    public boolean projectDone(ProjectManagement projectManagement, int status) {

        LambdaUpdateWrapper<Project> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Project::getMentorId, projectManagement.getMentorId());
        wrapper.eq(Project::getProjectId, projectManagement.getProjectId());
        wrapper.set(Project::getProjectDoneStatus, status);
        boolean rowsAffected = this.update(null, wrapper); // 如果使用ProjectMapper
        return rowsAffected;
    }

    @Override
    public Map<String, Object> getProjectLevelTop5() {
        Map<String, Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
//        wrapper.notIn(Project::getProjectDoneStatus, Arrays.asList(0, 3));
        wrapper.orderByDesc(Project::getProjectLevel).last("LIMIT 5");
        List<Project> top15Projects = this.baseMapper.selectList(wrapper);
        if (!top15Projects.isEmpty()) {
            projectMap.put("data", top15Projects);
        } else {
            return null;
        }
        return projectMap;
    }

    @Override
    public List<ProjectAddDataDTO> projectShowWithData() {

        List<ProjectAddDataDTO> projectList = this.baseMapper.projectShowWithData();
        return projectList;
    }

    @Override
    public boolean projectUpdateDoneStatus(Project project) {
        LambdaUpdateWrapper<Project> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Project::getProjectId,project.getProjectId());
        wrapper.set(Project::getProjectDoneStatus,project.getProjectDoneStatus());
        boolean flag = this.update(project,wrapper);
        return flag;

    }

}
