package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.MentorAudit;
import com.example.university_project_platform_backend.service.IMentorAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
@RestController
@RequestMapping("/mentorAudit")
public class MentorAuditController {
    @Autowired
    IMentorAuditService iMentorAuditService;
    @GetMapping("/show")
    public JsonResult<List<MentorAudit>> mentorAuditShow(){
        List<MentorAudit> mentorAuditList = iMentorAuditService.list();
        System.out.println(mentorAuditList);
        return JsonResult.ResultSuccess(mentorAuditList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> mentorAuditAdd(@RequestBody MentorAudit mentorAudit){
        Map<String,Object> mentorAuditMap = new HashMap<>();
        boolean mentorAuditFlag = iMentorAuditService.save(mentorAudit);
        if (mentorAuditFlag){
            mentorAuditMap.put("data",mentorAudit);
            return JsonResult.ResultSuccess(mentorAuditMap);
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> mentorAuditDelete(@RequestBody MentorAudit mentorAudit){
        boolean mentorAuditFlag = iMentorAuditService.removeById(mentorAudit.getMentorAuditId());
        if (mentorAuditFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+mentorAudit.getMentorAuditId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+mentorAudit.getMentorAuditId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> mentorAuditChange(@RequestBody MentorAudit mentorAudit){
        Map<String,Object> mentorAuditMap = new HashMap<>();
        boolean dataFlag = iMentorAuditService.updateById(mentorAudit);
        if (dataFlag){
            mentorAuditMap.put("data",mentorAudit);
            return JsonResult.ResultSuccess(mentorAuditMap);
        }else {
            return JsonResult.ResultFail();
        }
    }

}
