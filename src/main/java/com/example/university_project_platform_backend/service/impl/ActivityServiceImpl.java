package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.entity.Activity;
import com.example.university_project_platform_backend.mapper.ActivityMapper;
import com.example.university_project_platform_backend.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
