package com.example.university_project_platform_backend.service.impl;

import com.example.university_project_platform_backend.entity.Mail;
import com.example.university_project_platform_backend.mapper.MailMapper;
import com.example.university_project_platform_backend.service.IMailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
@Service
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements IMailService {

    @Override
    public List<Mail> getMailListByMail(Mail mail) {
        List<Mail> mailList = baseMapper.getMailListByMail(mail);
        return mailList;
    }

    @Override
    public Map<String, Object> sendMailMessageForUserList(Mail mail) {
        return null;
    }
}
