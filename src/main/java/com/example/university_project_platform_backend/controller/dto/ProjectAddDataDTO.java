package com.example.university_project_platform_backend.controller.dto;

import com.example.university_project_platform_backend.entity.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProjectAddDataDTO extends Project {

    private Long groupId;

    private String groupName;

    private Long mentorId;

    private String mentorName;

    private Long studentId;

    private String studentName;

    private List<Integer> projectDoneStatusList;

}
