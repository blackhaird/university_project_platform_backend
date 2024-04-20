package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.controller.dto.ProjectAddDataDTO;
import com.example.university_project_platform_backend.controller.dto.ProjectProjectManagementDTO;
import com.example.university_project_platform_backend.controller.dto.StudentMentorDTO;
import com.example.university_project_platform_backend.entity.*;
import com.example.university_project_platform_backend.service.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
import com.example.university_project_platform_backend.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-03-03
 */
@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    private IMentorService iMentorService;
    @Autowired
    private IStudentGroupService iStudentGroupService;
    @Autowired
    private IProjectManagementService iProjectManagementService;
    @Autowired
    private IProjectService iProjectService;
    @Autowired
    private IProjectManagementOperationService iProjectManagementOperationService;
    @Autowired
    private IStudentAuditService iStudentAuditService;
    @Autowired
    private ICreditsAuditService iCreditsAuditService;

    @PostMapping("/test")
    public JsonResult<Object> mentorTest(@RequestBody String mentorId) {
        System.out.println("mentorTest Running ：" + mentorId);
        return JsonResult.ResultSuccess(iMentorService.isMentorFromMentorID(mentorId));
    }

    @GetMapping("/show")
    public JsonResult<List<Mentor>> mentorShow() {
        List<Mentor> mentorList = iMentorService.list();
        System.out.println(mentorList);
        return JsonResult.ResultSuccess(mentorList);
    }


    @PostMapping("/add")
    public JsonResult<Map<String, Object>> mentorAdd(@RequestBody Mentor mentor) {
        Map<String, Object> map = iMentorService.getMentorsFormMentorID(mentor.getMentorId());
        if (map.get("data") != null) {
            return JsonResult.ResultSuccess("已有[" + mentor.getMentorId() + "] 的数据");
        } else {
            boolean mentorFlag = iMentorService.save(mentor);
            long mentorid = mentor.getMentorId();
            if (mentorFlag) {
                return JsonResult.ResultSuccess(iMentorService.getMentorsFormMentorID(mentorid));
            }
            return JsonResult.ResultFail(204, "找不到数据");
        }
    }

    @PostMapping("/del")
    public JsonResult<Map<String, Object>> mentorDelete(@RequestBody Mentor mentor) {
        boolean mentorFlag = iMentorService.mentorDelete(mentor.getMentorId());
        if (mentorFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + mentor.getMentorId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + mentor.getMentorId() + " ] 找不到ID或数据冲突");
    }

    @PostMapping("/change")
    public JsonResult<Map<String, Object>> mentorChange(@RequestBody Mentor mentor) {
        Map<String, Object> data = iMentorService.mentorUpdate(mentor);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/studentGroupAdd")
    public JsonResult<Map<String, Object>> mentorStudentGroupAdd(@RequestBody StudentGroup studentGroup) {
        boolean studentGroupFlag = iStudentGroupService.save(studentGroup);
        long studentGroupId = studentGroup.getGroupId();
        if (studentGroupFlag) {
            return JsonResult.ResultSuccess(iStudentGroupService.getStudentGroupsFormStudentID(studentGroupId));
        }
        return JsonResult.ResultFail(204, "找不到数据");
    }

    @PostMapping("/studentGroupDel")
    public JsonResult<Map<String, Object>> mentorStudentGroupDel(@RequestBody StudentGroup studentGroup) {
        boolean studentGroupFlag = iStudentGroupService.studentGroupDeleteByMentorId(studentGroup.getGroupMentorId(), studentGroup.getGroupId());
        if (studentGroupFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + studentGroup.getGroupId() + " ]");
        }
        return JsonResult.ResultFail("删除失败 [ " + studentGroup.getGroupId() + " ] 找不到ID或数据冲突");
    }

    @PostMapping("/studentGroupChange")
    public JsonResult<Map<String, Object>> mentorStudentGroupChange(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> data = iStudentGroupService.studentGroupUpdateByMentorId(studentGroup.getGroupMentorId(), studentGroup);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/studentGroupSearch")
    public JsonResult<Map<String, Object>> mentorStudentGroupSearch(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> studentGroupList = iStudentGroupService.studentGroupSearchByStudentGroup(studentGroup);
        if (studentGroupList != null) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultFail(studentGroupList.get("message").toString());
        }
    }


    @PostMapping("/studentGroupShow")
    public JsonResult<Map<String, Object>> mentorStudentGroupShow(@RequestBody StudentGroup studentGroup) {
        Map<String, Object> studentGroupList = iStudentGroupService.studentGroupShowByMentorId(studentGroup.getGroupMentorId());
        System.out.println(studentGroupList.toString());
        if (!studentGroupList.isEmpty()) {
            System.out.println("success");
            return JsonResult.ResultSuccess(studentGroupList);
        } else {
            return JsonResult.ResultSuccess();
        }
    }

    @PostMapping("/projectUpdate")
    public JsonResult<Map<String, Object>> projectUpdate(@RequestBody Project project) {
        Long mentorId = project.getMentorId();
        Map<String, Object> data = iProjectService.projectUpdateByProjectCreator(mentorId, project);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/projectDel")
    public JsonResult<Map<String, Object>> projectDel(@RequestBody Project project) {
        Long mentorId = project.getMentorId();
        boolean projectFlag = iProjectService.projectDeleteByProjectCreator(mentorId, project.getProjectId());
        if (projectFlag) {
            return JsonResult.ResultSuccess("删除成功 [ " + project.getProjectId() + " ]");
        }
        return JsonResult.ResultFail();
    }

    //目前
    @PostMapping("/projectManagementAdd")
    public JsonResult<Map<String, Object>> projectManagementAdd(@RequestBody MentorProjectDTO mentorProjectDTO) throws IOException {
        Long userId = mentorProjectDTO.getMentorId();
//        String url = iFileService.uploadFile(file, UUID.randomUUID().toString().substring(0, 10) + "_" + file.getOriginalFilename());
//        mentorProjectDTO.setProjectProposalLink(url);
        Map<String, Object> projectManageMap = iProjectManagementService.projectManagementSubmitByProjectMentorDTO(mentorProjectDTO);
        if (projectManageMap.get("data") == null) {
            iProjectManagementOperationService.projectManagementOperationAdd(userId, mentorProjectDTO, (byte) 0, "/mentor/projectManagementAdd");
            return JsonResult.ResultFail(projectManageMap.get("message").toString());
        } else {
            iProjectManagementOperationService.projectManagementOperationAdd(userId, mentorProjectDTO, (byte) 1, "/mentor/projectManagementAdd");
            return JsonResult.ResultSuccess(projectManageMap);
        }
    }


    @PostMapping("/projectManagementShow")
    public JsonResult<Map<String, Object>> projectManagementShow(@RequestBody MentorProjectDTO mentorProjectDTO) {
        Map<String, Object> data = iProjectManagementService.projectManagementSelectByMentorProjectDTO(mentorProjectDTO);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    //待测试
    @PostMapping("/projectManagementUpdate")
    public JsonResult<Map<String, Object>> projectManagementUpdate(@RequestBody ProjectManagement projectManagement) {

        Long mentorId = projectManagement.getMentorId();
        MentorProjectDTO mentorProjectDTO = new MentorProjectDTO();
        mentorProjectDTO.setProjectId(projectManagement.getProjectId());

        Map<String, Object> data = iProjectManagementService.projectManagementUpdateByMentorId(mentorId, projectManagement);
        if (data != null) {
            iProjectManagementOperationService.projectManagementOperationAdd(mentorId, mentorProjectDTO, (byte) 1, "/mentor/projectManagementDel");
            return JsonResult.ResultSuccess(data);
        } else {
            iProjectManagementOperationService.projectManagementOperationAdd(mentorId, mentorProjectDTO, (byte) 0, "/mentor/projectManagementDel");
            return JsonResult.ResultFail();
        }
    }


    @PostMapping("/projectManagementDel")
    public JsonResult<Map<String, Object>> projectManagementDel(@RequestBody ProjectManagement projectManagement) {
        Long mentorId = projectManagement.getMentorId();

        MentorProjectDTO mentorProjectDTO = new MentorProjectDTO();
        mentorProjectDTO.setProjectId(projectManagement.getProjectId());

        boolean projectManagementFlag = iProjectManagementService.projectManagementDeleteByMentorId(mentorId, projectManagement.getProjectId());

        if (projectManagementFlag) {
            iProjectManagementOperationService.projectManagementOperationAdd(mentorId, mentorProjectDTO, (byte) 1, "/mentor/projectManagementDel");
            return JsonResult.ResultSuccess("删除成功 [ " + projectManagement.getProjectId() + " ]");
        } else {
            iProjectManagementOperationService.projectManagementOperationAdd(mentorId, mentorProjectDTO, (byte) 0, "/mentor/projectManagementDel");
            return JsonResult.ResultFail("删除失败 [ " + projectManagement.getProjectId() + " ] 找不到ID或数据冲突");

        }
    }

    @PostMapping("/showMentorStudent")
    public JsonResult<Map<String, Object>> studentShowStudentTeacher(@RequestBody StudentMentorDTO student) {
        Map<String, Object> data = iMentorService.getStudentTeacherByStudentId(student.getMentorId());
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail("查询不到该数据，请检查查询参数");
        }
    }

    @PostMapping("/projectManagementSearch")
    public JsonResult<Map<String, Object>> projectManagementSearch(@RequestBody ProjectManagement projectManagement) {
        Map<String, Object> data = iProjectManagementService.projectManagementSearchByMentorProjectDTO(projectManagement);
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail("查询不到该数据，请检查查询参数");
        }
    }

    @PostMapping("/showMentorProject")
    public JsonResult<Map<String, Object>> studentShowMentorProject(@RequestBody ProjectAddDataDTO mentorDTO) {
        System.out.println(mentorDTO.getMentorId());
        Map<String, Object> data = iProjectService.getStudentsProjectByMentorId(mentorDTO.getMentorId());
        if (data != null) {
            return JsonResult.ResultSuccess(data);
        } else {
            return JsonResult.ResultFail();
        }
    }

    /**
     * [0.3.5]
     */
    @PostMapping("/projectAdd")
    public JsonResult<Map<String, Object>> projectAdd(@RequestBody Project project) {
        Long mentorId = project.getMentorId();
        boolean projectFlag = iProjectService.save(project);
        if (projectFlag) {
            Map<String, Object> projectManageMap = iProjectManagementService.projectManagementSubmitByMentor(mentorId, project);

            if (projectManageMap.get("data") != null) {
                return JsonResult.ResultSuccess(projectManageMap);
            } else {
                return JsonResult.ResultFail(projectManageMap.get("message").toString());
            }
        } else {
            return JsonResult.ResultFail("项目新增失败，可能是Project表创建出现问题");
        }
    }

    @PostMapping("/studentAuditUpdate")
    public JsonResult<Map<String, Object>> studentAuditUpdate(@RequestBody StudentAudit studentAudit) {
        boolean studentAuditSubmit = iStudentAuditService.studentAuditUpdate(studentAudit);
        if (studentAuditSubmit) {
            Map<String, Object> studentGroupAdd = iStudentGroupService.studentGroupSave(studentAudit);
            if (studentGroupAdd.get("data") != null) {
                return JsonResult.ResultSuccess(studentGroupAdd);
            } else {
                return JsonResult.ResultFail(studentGroupAdd.get("message").toString());
            }
        } else {
            return JsonResult.ResultFail();
        }
    }

    @PostMapping("/projectDone")
    @Transactional
    public JsonResult<Map<String, Object>> projectDone(@RequestBody ProjectManagement projectManagement) {
        boolean projectDone = iProjectService.projectDone(projectManagement, 2);
        if (projectDone) {
            System.out.println("项目完成");
            Map<String, Object> creditsList = iCreditsAuditService.creditsAuditSubmit(projectManagement);
            if (creditsList.get("data") != null) {
                return JsonResult.ResultSuccess(creditsList);
            } else {
                return JsonResult.ResultFail(creditsList.get("message").toString());
            }
        } else {
            return JsonResult.ResultFail("项目完成失败");
        }
    }
}





