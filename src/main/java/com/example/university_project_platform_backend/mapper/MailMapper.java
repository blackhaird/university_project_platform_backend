package com.example.university_project_platform_backend.mapper;

import com.example.university_project_platform_backend.entity.Mail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
public interface MailMapper extends BaseMapper<Mail> {

    List<Mail> getMailListByMail(Mail mail);
}
