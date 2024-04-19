package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.StudentAudit;
import com.example.university_project_platform_backend.entity.StudentGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
public interface IStudentGroupService extends IService<StudentGroup> {

    Map<String, Object> studentGroupUpdate(StudentGroup studentGroup);

    Map<String, Object> getStudentGroupsFormStudentID(long studentGroupId);

    boolean studentGroupDelete(Long studentGroupId);

    Map<String, Object> studentGroupShowByMentorId(Long mentorId);

    Map<String, Object> studentGroupSearchByStudentGroup(StudentGroup studentGroup);

    boolean studentGroupDeleteByMentorId(Long groupMentorId, Long groupId);

    Map<String, Object> studentGroupUpdateByMentorId(Long groupMentorId, StudentGroup studentGroup);

    Map<String, Object> joinStudentGroup(Long groupStudentId,StudentGroup studentGroup);

    Map<String, Object> studentGroupShowByStudentID(Long groupStudentId);

    Long getMaxStudentGroupId();

    Map<String, Object> studentGroupSave(StudentAudit studentAudit);
}
