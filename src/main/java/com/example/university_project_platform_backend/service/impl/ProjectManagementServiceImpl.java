package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.controller.dto.ProjectActivityDTO;
import com.example.university_project_platform_backend.controller.dto.ProjectProjectManagementDTO;
import com.example.university_project_platform_backend.entity.*;
import com.example.university_project_platform_backend.mapper.ProjectManagementMapper;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.university_project_platform_backend.service.IProjectService;
import com.example.university_project_platform_backend.service.IStudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ProjectManagementServiceImpl extends ServiceImpl<ProjectManagementMapper, ProjectManagement> implements IProjectManagementService {
    @Autowired
    IProjectService iProjectService;
    @Autowired
    IStudentGroupService iStudentGroupService;


    @Override
    public Map<String, Object> projectManagementSubmitByProjectMentorDTO(MentorProjectDTO mentorProjectDTO) {
        Map<String, Object> resultMap = new HashMap<>();
        //实例化学生组与项目管理
        StudentGroup studentGroup = new StudentGroup();
        ProjectManagement projectManagement = new ProjectManagement();
        //查询项目表有无冲突数据
        LambdaQueryWrapper<Project> projectWrapper = new LambdaQueryWrapper<>();
        projectWrapper.eq(Project::getProjectId, mentorProjectDTO.getProjectId());
        List<Project> projectList = iProjectService.list(projectWrapper);
        if (projectList.isEmpty()&&mentorProjectDTO.getCompetitionId()!=null) {
            boolean projectFlag = iProjectService.save(mentorProjectDTO);
            //验证存入数据情况
            if (projectFlag) {
                LambdaQueryWrapper<StudentGroup> studentGroupWrapper = new LambdaQueryWrapper<>();
                studentGroupWrapper.eq(StudentGroup::getGroupId, mentorProjectDTO.getGroupId());
                StudentGroup studentGroupList = iStudentGroupService.getOne(studentGroupWrapper);
                if (studentGroupList == null) {
                    //        新建学生组
                    studentGroup.setGroupId(mentorProjectDTO.getGroupId());
                    this.baseMapper.studentGroupInsertAuto(studentGroup);
                    System.out.println(studentGroup.getGroupId() + " and " + studentGroup.getGroupName());

                    projectManagement.setProjectId(mentorProjectDTO.getProjectId());
                    projectManagement.setCompetitionId(mentorProjectDTO.getCompetitionId());
                    projectManagement.setMentorId(mentorProjectDTO.getMentorId());
                    projectManagement.setGroupId(studentGroup.getGroupId());

                } else {
                    System.out.println("running:the studentGroupList != NULL");
                    if (studentGroupList.getGroupMentorId().equals(mentorProjectDTO.getMentorId())) {

                        projectManagement.setProjectId(mentorProjectDTO.getProjectId());
                        projectManagement.setCompetitionId(mentorProjectDTO.getCompetitionId());
                        projectManagement.setMentorId(mentorProjectDTO.getMentorId());
                        projectManagement.setGroupId(studentGroupList.getGroupId());

                    } else {
                        resultMap.put("message", "学生组数据创建失败，已有数据冲突学生组,或该学生组数据不属于本教师");
                    }
                }
                boolean projectManagementFlag = this.save(projectManagement);
                if (projectManagementFlag) {
                    resultMap.put("data", mentorProjectDTO);
                } else {
                    resultMap.put("message", "最终数据创建失败，已有项目管理组");
                }

            } else {
                resultMap.put("message", "项目组数据创建失败，已有数据冲突项目组");
            }
        }else {
            resultMap.put("message", "项目数据创建失败，已有数据冲突项目数据或缺少重要数据");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> projectManagementSelectByMentorProjectDTO(MentorProjectDTO mentorProjectDTO) {
        Map<String,Object> projectManagementMap = new HashMap<>();
        List<MentorProjectDTO> projectManagementList = this.baseMapper.projectManagementSelectByCompetitionId(mentorProjectDTO);
        projectManagementMap.put("data",projectManagementList);
        return projectManagementMap;
    }

    @Override
    public Map<String, Object> projectManagementUpdateByMentorId(Long mentorId,ProjectManagement projectManagement) {
        LambdaQueryWrapper<ProjectManagement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProjectManagement::getMentorId,mentorId);
        wrapper.eq(ProjectManagement::getProjectId,projectManagement.getMentorId());
        boolean projectManagementFlag = this.update(projectManagement,wrapper);
        if (projectManagementFlag){
            ProjectManagement projectManagementList = this.getOne(wrapper);
            Map<String,Object> projectManagementMap = new HashMap<>();
            projectManagementMap.put("data",projectManagementList);
            return projectManagementMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> projectManagementReview(Long competitionId,ProjectManagement projectManagement) {
        Map<String,Object> projectManagementMap = new HashMap<>();
        if (competitionId.equals(projectManagement.getCompetitionId())){
            LambdaUpdateWrapper<ProjectManagement> projectManagementUpdateWrapper =   new LambdaUpdateWrapper<>();
            projectManagementUpdateWrapper.set(ProjectManagement::getProjectStatusId,projectManagement.getProjectStatusId());
            projectManagementUpdateWrapper.set(ProjectManagement::getProjectStatusDescription,projectManagement.getProjectStatusDescription());
            projectManagementUpdateWrapper.eq(ProjectManagement::getCompetitionId,competitionId);
            projectManagementUpdateWrapper.eq(ProjectManagement::getProjectId,projectManagement.getProjectId());
            int projectManagementFlag = this.baseMapper.update(projectManagement,projectManagementUpdateWrapper);
            System.out.println(projectManagementFlag);
            if (projectManagementFlag!=0){
                LambdaQueryWrapper<ProjectManagement> projectManagementQueryWrapper = new LambdaQueryWrapper<>();
                projectManagementQueryWrapper.eq(ProjectManagement::getCompetitionId,competitionId);
                projectManagementQueryWrapper.eq(ProjectManagement::getProjectId,projectManagement.getProjectId());
                List<ProjectManagement> projectManagementList = this.list(projectManagementQueryWrapper);
                projectManagementMap.put("data",projectManagementList);
            }else {
                projectManagementMap.put("data",null);
            }
        }
        return projectManagementMap;
    }

    @Override
    public boolean projectManagementDeleteByMentorId(Long mentorId, Long projectId) {
        LambdaQueryWrapper<ProjectManagement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProjectManagement::getMentorId, mentorId);
        wrapper.eq(ProjectManagement::getProjectId, projectId);
        int mentorFlag = this.baseMapper.delete(wrapper);
        if (mentorFlag!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Map<String, Object> projectManagementSearchByMentorProjectDTO(ProjectManagement projectManagement) {
        Map<String,Object> projectMap = new HashMap<>();
        LambdaQueryWrapper<ProjectManagement> wrapper = new LambdaQueryWrapper<>();
        if (projectManagement.getMentorId() != null) {
            wrapper.eq(ProjectManagement::getMentorId, projectManagement.getMentorId());
        }
        if (projectManagement.getCompetitionId() != null) {
            wrapper.eq(ProjectManagement::getCompetitionId, projectManagement.getCompetitionId());
        }
        if (projectManagement.getGroupId() != null) {
            wrapper.eq(ProjectManagement::getGroupId, projectManagement.getGroupId());
        }
        if (projectManagement.getProjectId() != null) {
            wrapper.eq(ProjectManagement::getProjectId, projectManagement.getProjectId());
        }
        if (projectManagement.getProjectStatusId() != 0) {
            wrapper.eq(ProjectManagement::getProjectStatusId, projectManagement.getProjectStatusId());
        }
        List<ProjectManagement> projectList = this.list(wrapper);
        if (!projectList.isEmpty()){
            projectMap.put("data",projectList);
            return projectMap;
        }else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> projectManagementSubmitByMentor(Long mentorId, Project project) {
        Map<String,Object> projectMap =  new HashMap<>();
        ProjectManagement projectManagement = new ProjectManagement();
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupMentorId(mentorId);
        studentGroup.setGroupId(iStudentGroupService.getMaxStudentGroupId() + 1);

        projectManagement.setMentorId(mentorId);
        projectManagement.setProjectId(project.getProjectId());

        try {
            iStudentGroupService.save(studentGroup);
            projectManagement.setGroupId(studentGroup.getGroupId());
            this.save(projectManagement);

        } catch (Exception e) {
            log.error("提交项目管理失败，已回滚事务", e);
            projectMap.put("message", "提交项目管理失败，已回滚事务");
        }
        List<ProjectProjectManagementDTO> projectProjectManagementDTO = this.baseMapper.getProjectProjectManagementDTOByProjectId(project.getProjectId(), project.getMentorId());
        projectMap.put("data", projectProjectManagementDTO);
        return projectMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> projectManagementSubmitForActivityByMentor(Long mentorId, ProjectActivityDTO projectActivityDTO) {
        Map<String,Object> projectMap =  new HashMap<>();
        /**
         * 项目状态id 0代表未通过 1代表通过 2代表审核中
         */
        ProjectManagement projectManagement = new ProjectManagement();
//        StudentGroup studentGroup = new StudentGroup();
//        studentGroup.setGroupMentorId(mentorId);
//        studentGroup.setGroupId(iStudentGroupService.getMaxStudentGroupId() + 1);

        projectManagement.setMentorId(mentorId);
        projectManagement.setProjectId(projectActivityDTO.getProjectId());
        projectManagement.setCompetitionId(projectActivityDTO.getCompetitionId());
        projectManagement.setProjectStatusId((byte)2);

        try {
//            iStudentGroupService.save(studentGroup);
            this.save(projectManagement);

        } catch (Exception e) {
            log.error("提交项目管理失败，已回滚事务", e);
            projectMap.put("message", "提交项目管理失败，已回滚事务");
        }
        List<ProjectProjectManagementDTO> projectProjectManagementDTO = this.baseMapper.getProjectProjectManagementDTOByProjectId(
                projectActivityDTO.getProjectId(), projectActivityDTO.getMentorId());
        projectMap.put("data", projectProjectManagementDTO);
        return projectMap;
    }

}
