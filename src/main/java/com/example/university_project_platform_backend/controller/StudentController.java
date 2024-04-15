package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.controller.dto.StudentMentorDTO;
import com.example.university_project_platform_backend.entity.ProjectManagement;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IProjectManagementService;
import com.example.university_project_platform_backend.service.IProjectService;
import com.example.university_project_platform_backend.service.IStudentGroupService;
import com.example.university_project_platform_backend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IProjectService iProjectService;

    @Autowired
    private IStudentGroupService iStudentGroupService;


    @PostMapping("/test")
    public JsonResult<Object> studentTest(@RequestBody String studentId){
        System.out.println("studentTest Running ：" + studentId);
        return JsonResult.ResultSuccess(iStudentService.isStudentFormStudentID(studentId));
    }

    @GetMapping("/show")
    public JsonResult<List<Student>> studentShow(){
        List<Student> studentList = iStudentService.list();
        System.out.println(studentList);
        return JsonResult.ResultSuccess(studentList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> studentAdd(@RequestBody Student student){
        boolean studentFlag = iStudentService.save(student);
        long studentid = student.getStudentId();
        if (studentFlag){
            return JsonResult.ResultSuccess(iStudentService.getStudentsFormStudentID(studentid));
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> studentDelete(@RequestBody Student student){
        boolean studentFlag = iStudentService.studentDelete(student.getStudentId());
        if (studentFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+student.getStudentId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+student.getStudentId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> studentChange(@RequestBody Student student){
        Map<String,Object> data = iStudentService.studentUpdate(student);
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/showStudentProject")
    public JsonResult<Map<String,Object>> studentShowStudentProject(@RequestBody ProjectAddDataDTO student){
        Map<String,Object> data = iProjectService.getStudentsProjectByStudentId(student.getStudentId());
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/showStudentMentor")
    public JsonResult<Map<String,Object>> studentShowStudentTeacher(@RequestBody StudentMentorDTO student){
        Map<String,Object> data = iStudentService.getStudentTeacherByStudentId(student.getStudentId());
        if (data!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail();
        }
    }


    @PostMapping("/joinStudentGroup")
    public JsonResult<Map<String,Object>> studentJoinStudentGroup(@RequestBody StudentGroup studentGroup){
        if (studentGroup.getGroupCreateTime()==null){
            studentGroup.setGroupCreateTime(LocalDateTime.now());
        }
        Map<String,Object> data = iStudentGroupService.joinStudentGroup(studentGroup.getGroupStudentId(),studentGroup);
        if (data.get("data")!=null){
            return JsonResult.ResultSuccess(data);
        }else {
            return JsonResult.ResultFail(data.get("message").toString());
        }
    }

    @PostMapping("/studentGroupShow")
    public JsonResult<Map<String, Object>> mentorStudentGroupShow(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> studentGroupList = iStudentGroupService.studentGroupShowByStudentID(studentGroup.getGroupStudentId());
        System.out.println(studentGroupList.toString());
        if (!studentGroupList.isEmpty()) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultSuccess();
        }
    }


}
