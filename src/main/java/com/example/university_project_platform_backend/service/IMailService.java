package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Mail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
public interface IMailService extends IService<Mail> {

    List<Mail> getMailListByMail(Mail mail);

    Map<String, Object> sendMailMessageForUserList(Mail mail);
}
