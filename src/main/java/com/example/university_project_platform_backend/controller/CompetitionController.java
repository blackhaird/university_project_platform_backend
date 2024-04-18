package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.service.IProjectManagementOperationService;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.example.university_project_platform_backend.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-16
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private IProjectManagementService iProjectManagementService;
    @Autowired
    IProjectService iProjectService;
    @Autowired
    IProjectManagementOperationService iProjectManagementOperationService;
    @PostMapping("/projectManagementAdd")
    public JsonResult<Map<String,Object>> projectManagementAdd(@RequestBody MentorProjectDTO mentorProjectDTO) {
        Long userId = mentorProjectDTO.getMentorId();
        Map<String,Object> projectManageMap = iProjectManagementService.projectManagementSubmitByProjectMentorDTO(mentorProjectDTO);
        if (projectManageMap.get("data")==null){
            iProjectManagementOperationService.projectManagementOperationAdd(userId, mentorProjectDTO,(byte) 0,"/projectManagementAdd");
            return JsonResult.ResultFail(projectManageMap.get("message").toString());
        }else {
            iProjectManagementOperationService.projectManagementOperationAdd(userId, mentorProjectDTO, (byte) 1,"/projectManagementAdd");
            return JsonResult.ResultSuccess(projectManageMap);
        }
    }


    @PostMapping("/projectManagementShow")
    public JsonResult<Map<String,Object>> projectManagementShow(@RequestBody MentorProjectDTO mentorProjectDTO) {
        Map<String,Object> projectManagementMap = iProjectManagementService.projectManagementSelectByMentorProjectDTO(mentorProjectDTO);
        return JsonResult.ResultSuccess(projectManagementMap);
    }


    @PostMapping("/projectManagementReview")
    public JsonResult<Map<String,Object>> projectManagementReview(@RequestBody ProjectManagement projectManagement) {
        Map<String,Object> projectManagementMap = iProjectManagementService.projectManagementReview(projectManagement.getCompetitionId(),projectManagement);
        if (projectManagementMap.get("data")==null){
            return JsonResult.ResultFail();
        }
        return JsonResult.ResultSuccess(projectManagementMap);
    }

    @PostMapping("/projectUpdate")
    public JsonResult<Map<String, Object>> projectUpdate(@RequestBody Project project) {
        System.out.println("running");
        Long mentorId = project.getMentorId();
        Map<String, Object> data = iProjectService.projectUpdateByProjectCreator(mentorId, project);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/projectManagementUpdate")
    public JsonResult<Map<String, Object>> projectManagementUpdate(@RequestBody ProjectManagement projectManagement) {
        Long mentorId = projectManagement.getMentorId();
        Map<String, Object> data = iProjectManagementService.projectManagementUpdateByMentorId(mentorId, projectManagement);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }
}