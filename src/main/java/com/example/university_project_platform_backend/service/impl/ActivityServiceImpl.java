package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Activity;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.mapper.ActivityMapper;
import com.example.university_project_platform_backend.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Override
    public Map<String, Object> getActivityNew() {
        Map<String, Object> activityMap = new HashMap<>();
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Activity::getActivityCreateTime).last("LIMIT 5");
        List<Activity> top5Activity = this.baseMapper.selectList(wrapper);
        if (!top5Activity.isEmpty()) {
            activityMap.put("data", top5Activity);
        } else {
            return null;
        }
        return activityMap;
    }

    @Override
    public Map<String, Object> activityShow(Activity activity) {
        Map<String, Object> activityMap = new HashMap<>();
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Activity::getCompetitionId, activity.getCompetitionId());
        List<Activity> activityList = this.baseMapper.selectList(wrapper);
        if (!activityList.isEmpty()) {
            activityMap.put("data", activityList);
        } else {
            activityMap.put("message", "找不到数据");
        }
        return activityMap;
    }
}
