package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.entity.StudentAudit;
import com.example.university_project_platform_backend.mapper.StudentAuditMapper;
import com.example.university_project_platform_backend.service.IStudentAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-18
 */
@Service
public class StudentAuditServiceImpl extends ServiceImpl<StudentAuditMapper, StudentAudit> implements IStudentAuditService {

}
