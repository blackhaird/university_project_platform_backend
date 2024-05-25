package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.StudentSubmit;
import com.example.university_project_platform_backend.service.IStudentSubmitService;
import com.example.university_project_platform_backend.service.IStudentAuditService;
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
 * @since 2024-05-26
 */
@RestController
@RequestMapping("/studentSubmit")
public class StudentSubmitController {
    @Autowired
    IStudentSubmitService iStudentSubmitService;
    @GetMapping("/show")
    public JsonResult<List<StudentSubmit>> studentSubmitShow(){
        List<StudentSubmit> studentSubmitList = iStudentSubmitService.list();
        System.out.println(studentSubmitList);
        return JsonResult.ResultSuccess(studentSubmitList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> studentSubmitAdd(@RequestBody StudentSubmit studentSubmit){
        Map<String,Object> studentSubmitMap = new HashMap<>();
        boolean studentSubmitFlag = iStudentSubmitService.save(studentSubmit);
        if (studentSubmitFlag){
            studentSubmitMap.put("data",studentSubmit);
            return JsonResult.ResultSuccess(studentSubmitMap);
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/showById")
    public JsonResult<Map<String, Object>> studentSubmitShowById(@RequestBody StudentSubmit studentSubmit){
        Map<String,Object> studentSubmitMap = iStudentSubmitService.getSubmitById(studentSubmit);
        if (studentSubmitMap.get("data") != null){
            return JsonResult.ResultSuccess(studentSubmitMap);
        }else {
            return JsonResult.ResultFail(204,studentSubmitMap.get("message").toString());
        }

    }
}
