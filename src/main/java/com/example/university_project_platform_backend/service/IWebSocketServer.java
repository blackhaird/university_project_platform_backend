package com.example.university_project_platform_backend.service;

import com.example.university_project_platform_backend.entity.Mail;
import com.example.university_project_platform_backend.entity.Websocket;
import jakarta.websocket.Session;

import java.util.Map;

public interface IWebSocketServer {
    void onOpen(Session session, String loginName);

    Map<String, Object> sendMessageForUser(Websocket webSocketUser);

    Map<String, Object> getWebSocketUserMap();

    Map<String, Object> sendMessageForUserList(Websocket webSocketUser);

    Map<String, Object> sendMailMessageForUserList(Mail mail);

    Map<String, Object> getMailUserMap(Mail mail);

    Map<String, Object> sendMailForUser(Mail mail);

    Map<String, Object> getMessageSend(Mail mail);

    Map<String, Object> getMessageBeSend(Mail mail);
}
