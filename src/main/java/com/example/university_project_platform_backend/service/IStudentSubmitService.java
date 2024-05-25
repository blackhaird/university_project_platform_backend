package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.StudentSubmit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-05-26
 */
public interface IStudentSubmitService extends IService<StudentSubmit> {

    Map<String,Object> getSubmitById(StudentSubmit studentSubmit);
}
