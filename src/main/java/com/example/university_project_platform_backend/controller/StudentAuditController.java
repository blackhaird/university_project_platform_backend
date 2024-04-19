package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.StudentAudit;
import com.example.university_project_platform_backend.service.IStudentAuditService;
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
 * @since 2024-04-18
 */
@RestController
@RequestMapping("/studentAudit")
public class StudentAuditController {
    @Autowired
    IStudentAuditService iStudentAuditService;
    @GetMapping("/show")
    public JsonResult<List<StudentAudit>> studentAuditShow(){
        List<StudentAudit> studentAuditList = iStudentAuditService.list();
        System.out.println(studentAuditList);
        return JsonResult.ResultSuccess(studentAuditList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> studentAuditAdd(@RequestBody StudentAudit studentAudit){
        Map<String,Object> studentAuditMap = new HashMap<>();
        boolean studentAuditFlag = iStudentAuditService.save(studentAudit);
        if (studentAuditFlag){
            studentAuditMap.put("data",studentAudit);
            return JsonResult.ResultSuccess(studentAuditMap);
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> studentAuditDelete(@RequestBody StudentAudit studentAudit){
        boolean studentAuditFlag = iStudentAuditService.removeById(studentAudit.getStudentAuditId());
        if (studentAuditFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+studentAudit.getStudentAuditId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+studentAudit.getStudentAuditId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> studentAuditChange(@RequestBody StudentAudit studentAudit){
        Map<String,Object> studentAuditMap = new HashMap<>();
        boolean dataFlag = iStudentAuditService.updateById(studentAudit);
        if (dataFlag){
            studentAuditMap.put("data",studentAudit);
            return JsonResult.ResultSuccess(studentAuditMap);
        }else {
            return JsonResult.ResultFail("未找到对应学生审计记录");
        }
    }
}
