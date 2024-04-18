package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.CreditsAudit;
import com.example.university_project_platform_backend.service.ICreditsAuditService;
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
@RequestMapping("/creditsAudit")
public class CreditsAuditController {
    @Autowired
    ICreditsAuditService iCreditsAuditService;
    @GetMapping("/show")
    public JsonResult<List<CreditsAudit>> creditsAuditShow(){
        List<CreditsAudit> creditsAuditList = iCreditsAuditService.list();
        System.out.println(creditsAuditList);
        return JsonResult.ResultSuccess(creditsAuditList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> creditsAuditAdd(@RequestBody CreditsAudit creditsAudit){
        Map<String,Object> creditsAuditMap = new HashMap<>();
        boolean creditsAuditFlag = iCreditsAuditService.save(creditsAudit);
        if (creditsAuditFlag){
            creditsAuditMap.put("data",creditsAudit);
            return JsonResult.ResultSuccess(creditsAuditMap);
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> creditsAuditDelete(@RequestBody CreditsAudit creditsAudit){
        boolean creditsAuditFlag = iCreditsAuditService.removeById(creditsAudit.getCreditsAuditId());
        if (creditsAuditFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+creditsAudit.getCreditsAuditId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+creditsAudit.getCreditsAuditId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> creditsAuditChange(@RequestBody CreditsAudit creditsAudit){
        Map<String,Object> creditsAuditMap = new HashMap<>();
        boolean dataFlag = iCreditsAuditService.updateById(creditsAudit);
        if (dataFlag){
            creditsAuditMap.put("data",creditsAudit);
            return JsonResult.ResultSuccess(creditsAuditMap);
        }else {
            return JsonResult.ResultFail();
        }
    }

}
