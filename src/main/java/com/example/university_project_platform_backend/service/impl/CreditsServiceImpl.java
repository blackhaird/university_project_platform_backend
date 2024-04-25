package com.example.university_project_platform_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.university_project_platform_backend.controller.dto.CreditsStudentDTO;
import com.example.university_project_platform_backend.controller.dto.UserCreditsDTO;
import com.example.university_project_platform_backend.entity.Credits;
import com.example.university_project_platform_backend.mapper.CreditsMapper;
import com.example.university_project_platform_backend.service.ICreditsOperationService;
import com.example.university_project_platform_backend.service.ICreditsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2024-03-30
 */
@Service
public class CreditsServiceImpl extends ServiceImpl<CreditsMapper, Credits> implements ICreditsService {
    @Autowired
    private ICreditsOperationService iCreditsOperationService;
    @Override
    public Map<String, Object> getCreditsByStudentId(long studentId) {
        Map<String,Object> creditsMap = new HashMap<>();
        List<CreditsStudentDTO> searchCreditsList = this.baseMapper.getCreditsWithStudent(studentId);
        creditsMap.put("data",searchCreditsList);
        return creditsMap;
    }

    @Override
    public boolean creditsAdd(long userId, UserCreditsDTO credits) {
        if (credits.getCreditsValue()>0){
            LambdaQueryWrapper<Credits> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Credits::getStudentId,credits.getStudentId());
            return this.update(credits,wrapper);
        }
        return false;
    }

    @Override
    public List<CreditsStudentDTO> getCredits() {
        List<CreditsStudentDTO> searchCreditsList = this.baseMapper.getCredits();
        return searchCreditsList;
    }


}
