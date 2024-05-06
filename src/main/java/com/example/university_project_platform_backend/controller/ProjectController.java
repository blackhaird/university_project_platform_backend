package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IProjectService iProjectService;

    private static Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @GetMapping("/show")
    public JsonResult<List<Project>> projectShow() {
        List<Project> projectList = iProjectService.list();
        System.out.println(projectList);
        return JsonResult.ResultSuccess(projectList);
    }

    @PostMapping("/showPost")
    public JsonResult<List<Project>> projectShowPost() {
        Object obj = redisTemplate.opsForValue().get("projectPost");
        if (obj ==null) {
            List<Project> projectList = iProjectService.list();
            System.out.println(projectList);
            redisTemplate.opsForValue().set("projectPost", projectList, 14400000, TimeUnit.MINUTES);
            return JsonResult.ResultSuccess(projectList);
        }else {
            logger.info("redis have data project");
            return JsonResult.ResultSuccess((List<Project>) obj);
        }
    }
    @PostMapping("/projectSearch")
    public JsonResult<Map<String, Object>> projectSearch(@RequestBody Project project) {
        Map<String, Object> projectList = iProjectService.projectSearchByProject(project);
        if (projectList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(projectList);
        } else {
            return JsonResult.ResultFail(projectList.get("message").toString());
        }
    }

    @PostMapping("/projectSearchWithData")
    public JsonResult<Map<String, Object>> projectSearchWithData(@RequestBody ProjectAddDataDTO projectAddDataDTO) {
        Map<String, Object> projectList = iProjectService.getProjectSearchWithStudentMentorData(projectAddDataDTO);
        if (projectList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(projectList);
        } else {
            return JsonResult.ResultFail(projectList.get("message").toString());
        }
    }



    @GetMapping("/getProjectNew")
    public JsonResult<Map<String, Object>> getProjectNew() {
        Object obj = redisTemplate.opsForValue().get("getProjectNew");
        if (obj ==null) {
            Map<String, Object> projectList = iProjectService.getProjectNew();
            if (projectList != null) {
                redisTemplate.opsForValue().set("projectPost", projectList, 14400000, TimeUnit.MINUTES);
                System.out.println("success");
                return JsonResult.ResultSuccess(projectList);
            } else {
                return JsonResult.ResultFail("查询不到该导师存在导师组");
            }
        }else {
            logger.info("redis have data project");
            return JsonResult.ResultSuccess((Map<String, Object>) obj);
        }

    }

    @GetMapping("/getProjectLevelTop5")
    public JsonResult<Map<String, Object>> getProjectLevelTop5() {
        Object obj = redisTemplate.opsForValue().get("getProjectLevelTop5");
        if (obj ==null) {
            Map<String, Object> projectList = iProjectService.getProjectLevelTop5();
            redisTemplate.opsForValue().set("getProjectLevelTop5", projectList, 14400000, TimeUnit.MINUTES);
            if (projectList != null) {
                System.out.println("success");
                return JsonResult.ResultSuccess(projectList);
            } else {
                return JsonResult.ResultFail();
            }
        }else {
            logger.info("redis have data project");
            return JsonResult.ResultSuccess((Map<String, Object>) obj);
        }
    }

    @GetMapping("/showWithData")
    public JsonResult<Map<String, Object>> projectShowWithData() {
        Object obj = redisTemplate.opsForValue().get("showWithData");
        if (obj ==null) {
            Map<String, Object> projectList = iProjectService.getProjectWithStudentMentorData();
            if (projectList != null) {
                System.out.println("success");
                redisTemplate.opsForValue().set("showWithData", projectList, 14400000, TimeUnit.MINUTES);
                return JsonResult.ResultSuccess(projectList);
            } else {
                return JsonResult.ResultFail("查询不到该导师存在导师组");
            }
        }else {
            logger.info("redis have data project");
            return JsonResult.ResultSuccess((Map<String, Object>) obj);
        }
    }

    @PostMapping("/projectSearchFuzzy")
    public JsonResult<Map<String, Object>> projectSearchFuzzy(@RequestBody Project project) {
        Map<String, Object> projectList = iProjectService.projectSearchByProjectNameFuzzy(project);
        if (projectList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(projectList);
        } else {
            return JsonResult.ResultFail(projectList.get("message").toString());
        }
    }


}
