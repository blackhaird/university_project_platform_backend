package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.example.university_project_platform_backend.entity.StudentSubmit;
import com.example.university_project_platform_backend.mapper.StudentSubmitMapper;
import com.example.university_project_platform_backend.service.IStudentSubmitService;
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
 * @since 2024-05-26
 */
@Service
public class StudentSubmitServiceImpl extends ServiceImpl<StudentSubmitMapper, StudentSubmit> implements IStudentSubmitService {

    @Override
    public Map<String,Object> getSubmitById(StudentSubmit studentSubmit) {
        Map<String,Object> studentSubmitMap = new HashMap<>();
        LambdaQueryWrapper<StudentSubmit> queryWrapper = new LambdaQueryWrapper<>();
        if (studentSubmit.getStudentId()!=null) {
            queryWrapper.eq(StudentSubmit::getStudentId, studentSubmit.getStudentId());
            if (studentSubmit.getProjectId()!=null){
                queryWrapper.eq(StudentSubmit::getProjectId, studentSubmit.getProjectId());
            }
            List<StudentSubmit> studentSubmitList = this.list(queryWrapper);
            if (!studentSubmitList.isEmpty()){
                studentSubmitMap.put("data",studentSubmitList);
                return studentSubmitMap;
            }else {
                studentSubmitMap.put("message","没有找到该学生提交信息");
            }
        }else {
            studentSubmitMap.put("message","请输入学生ID");
        }
        return null;
    }
}
