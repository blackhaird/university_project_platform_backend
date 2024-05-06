package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Activity;
import com.example.university_project_platform_backend.service.IActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
 * @since 2024-04-19
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    IActivityService iActivityService;

    @Autowired
    RedisTemplate redisTemplate;

    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);
    @GetMapping("/show")
    public JsonResult<List<Activity>> activityShow(){
        List<Activity> activityList = iActivityService.list();
        System.out.println(activityList);
        return JsonResult.ResultSuccess(activityList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> activityAdd(@RequestBody Activity activity){
        Map<String,Object> activityMap = new HashMap<>();
        boolean activityFlag = iActivityService.save(activity);
        if (activityFlag){
            activityMap.put("data",activity);
            return JsonResult.ResultSuccess(activityMap);
        }
        return JsonResult.ResultFail(204,"找不到数据");
    }

    @PostMapping("/del")
    public JsonResult<Map<String,Object>> activityDelete(@RequestBody Activity activity){
        boolean activityFlag = iActivityService.removeById(activity.getActivityId());
        if (activityFlag){
            return JsonResult.ResultSuccess("删除成功 [ "+activity.getActivityId()+" ]");
        }
        return JsonResult.ResultFail("删除失败 [ "+activity.getActivityId()+" ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String,Object>> activityChange(@RequestBody Activity activity){
        Map<String,Object> activityMap = new HashMap<>();
        boolean dataFlag = iActivityService.updateById(activity);
        if (dataFlag){
            activityMap.put("data",activity);
            return JsonResult.ResultSuccess(activityMap);
        }else {
            return JsonResult.ResultFail();
        }
    }
    @PostMapping("/search")
    public JsonResult<Map<String,Object>> activitySearch(@RequestBody Activity activity){
        Map<String,Object> activityMap = new HashMap<>();
        Activity activity1 = iActivityService.getById(activity.getActivityId());
        if (activity1 != null){
            activityMap.put("data",activity1);
            return JsonResult.ResultSuccess(activityMap);
        }else {
            return JsonResult.ResultFail("查询不到该导师存在导师组");
        }
    }
    @GetMapping("/getActivityNew")
    public JsonResult<Map<String, Object>> getActivityNew() {

        Object obj = redisTemplate.opsForValue().get("projectPost");
        if (obj ==null) {
            Map<String, Object> activityList = iActivityService.getActivityNew();
            if (activityList != null) {
                System.out.println("success");
                return JsonResult.ResultSuccess(activityList);
            } else {
                return JsonResult.ResultFail("查询不到该导师存在导师组");
            }
        }else {
            logger.info("redis have data project");
            return JsonResult.ResultSuccess((Map<String, Object>) obj);
        }

    }
}
