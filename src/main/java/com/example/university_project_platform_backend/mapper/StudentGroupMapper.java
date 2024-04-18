package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.StudentGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface StudentGroupMapper extends BaseMapper<StudentGroup> {

    Long selectMaxStudentGroupId();
}
