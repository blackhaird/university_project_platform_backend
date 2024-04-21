package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
public interface IActivityService extends IService<Activity> {

    Map<String, Object> getActivityNew();

    Map<String, Object> activityShow(Activity activity);
}
