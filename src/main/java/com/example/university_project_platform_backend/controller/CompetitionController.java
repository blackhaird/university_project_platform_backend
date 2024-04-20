package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.*;
import com.example.university_project_platform_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    ICompetitionService iCompetitionService;
    @Autowired
    ICreditsAuditService iCreditsAuditService;
    @GetMapping("/show")
    public JsonResult<List<Competition>> competitionShow(){
        List<Competition> competitionList = iCompetitionService.list();
        System.out.println(competitionList);
        return JsonResult.ResultSuccess(competitionList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> competitionAdd(@RequestBody Competition competition){
        Map<String, Object> competitionMap = new HashMap<>();
        Map<String,Object> map = iCompetitionService.getMentorsFormCompetitionId(competition.getCompetitionId());
        if (map.get("data")!=null) {
            return JsonResult.ResultSuccess("已有[" + competition.getCompetitionId() +"] 的数据");
        }else {
            boolean competitionFlag = iCompetitionService.save(competition);
            if (competitionFlag) {
                competitionMap.put("data", competition);
                return JsonResult.ResultSuccess(competitionMap);
            }
            return JsonResult.ResultFail(204, "找不到数据");
        }
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> competitionDelete(@RequestBody Competition competition){
        boolean competitionFlag = iCompetitionService.removeById(competition.getCompetitionId());
        if (competitionFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+competition.getCompetitionId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+competition.getCompetitionId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> competitionChange(@RequestBody Competition competition){
        Map<String,Object> competitionMap = new HashMap<>();
        boolean dataFlag = iCompetitionService.updateById(competition);
        if (dataFlag){
            competitionMap.put("data",competition);
            return JsonResult.ResultSuccess(competitionMap);
        }else {
            return JsonResult.ResultFail("未找到对应学生审计记录");
        }
    }
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


    @PostMapping("/creditsAuditUpdate")
    public JsonResult<Map<String, Object>> creditsAuditUpdate(@RequestBody CreditsAudit creditsAudit) {
        Map<String, Object> data = iCreditsAuditService.creditsAuditUpdate(creditsAudit);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail(data.get("message").toString());
        }
    }
}