package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.controller.dto.UserCreditsDTO;
import com.example.university_project_platform_backend.entity.CreditsOperation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-01
 */
public interface ICreditsOperationService extends IService<CreditsOperation> {

    boolean creditsOperationAdd(long userid ,UserCreditsDTO credits,Byte isSuccess,String operationDescription);
}
