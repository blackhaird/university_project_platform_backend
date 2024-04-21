package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.controller.dto.MentorProjectDTO;
import com.example.university_project_platform_backend.entity.Competition;
import com.example.university_project_platform_backend.entity.Mentor;
import com.example.university_project_platform_backend.entity.Project;
import com.example.university_project_platform_backend.entity.Student;
import com.example.university_project_platform_backend.mapper.CompetitionMapper;
import com.example.university_project_platform_backend.service.ICompetitionService;
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
 * @since 2024-03-16
 */
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements ICompetitionService {

    @Override
    public Map<String, Object> projectManagementSubmitByMentorProjectDTO(MentorProjectDTO mentorProjectDTO) {

        return null;
    }

    @Override
    public boolean isCompetitionFromCompetitionID(String userName) {
        LambdaQueryWrapper<Competition> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Competition::getCompetitionId, userName);
        System.out.println(userName);
        List<Competition> searchList = this.list(wrapper);
        if (searchList.size() == 0) {
            return false;
        } else {
            System.out.println(searchList);
            return true;
        }
    }

    @Override
    public Map<String, Object> getMentorsFormCompetitionId(Long competitionId) {
        Map<String,Object> mentorMap = new HashMap<>();
        LambdaQueryWrapper<Competition> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Competition::getCompetitionId,competitionId);
        System.out.println(competitionId);
        List<Competition> searchMentorList = this.list(wrapper);
        if (searchMentorList.isEmpty()){
            System.out.println("找不到数据");
        }else {
            mentorMap.put("data",searchMentorList);
        }
        return mentorMap;
    }
}
