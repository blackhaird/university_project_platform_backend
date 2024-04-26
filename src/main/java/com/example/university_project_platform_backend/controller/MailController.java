package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Mail;
import com.example.university_project_platform_backend.entity.WebSocketUser;
import com.example.university_project_platform_backend.entity.Websocket;
import com.example.university_project_platform_backend.service.IFileService;
import com.example.university_project_platform_backend.service.IMailService;
import com.example.university_project_platform_backend.service.IWebSocketServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author blackhaird
 * @since 2024-04-19
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    IWebSocketServer iWebSocketServer;
    @Autowired
    IFileService iFileService;

    @Autowired
    IMailService iMailService;
    @PostMapping("/sendForUserList")
    public JsonResult<Map<String, Object>> sendForUserList(@RequestBody Mail mail ){
        System.out.println(mail.toString());
        mail.setMailTime(LocalDateTime.now());
        boolean mailFlag =iMailService.save(mail);
        Map<String,Object> keys =iWebSocketServer.sendMailMessageForUserList(mail);
        return JsonResult.ResultSuccess(keys);
    }
    @PostMapping("/getMessage")
    public JsonResult<Map<String, Object>> getMessage(@RequestBody Mail mail){
        Map<String,Object> keys =iWebSocketServer.getMailUserMap(mail);
        System.out.println(keys.size());
        return JsonResult.ResultSuccess(keys);
    }
    @PostMapping("/getMessageSend")
    public JsonResult<Map<String, Object>> getMessageSend(@RequestBody Mail mail){
        Map<String,Object> keys =iWebSocketServer.getMessageSend(mail);
        System.out.println(keys.size());
        return JsonResult.ResultSuccess(keys);
    }
    @PostMapping("/getMessageBeSend")
    public JsonResult<Map<String, Object>> getMessageBeSend(@RequestBody Mail mail){
        Map<String,Object> keys =iWebSocketServer.getMessageBeSend(mail);
        System.out.println(keys.size());
        return JsonResult.ResultSuccess(keys);
    }
    @PostMapping("/sendForUser")
    public JsonResult<Map<String, Object>> sendForUser(@RequestBody Mail mail ){
        System.out.println(mail.toString());
        mail.setMailTime(LocalDateTime.now());
        boolean mailFlag =iMailService.save(mail);
        Map<String,Object> keys =iWebSocketServer.sendMailForUser(mail);
        return JsonResult.ResultSuccess(keys);
    }

//    @RequestMapping("/upload")
//    public JsonResult<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        // 保存文件到服务器的代码
//        Map<String,Object> map = new HashMap<>();
//        String url = iFileService.uploadFile(file,"mailFile" , UUID.randomUUID().toString().substring(0, 10) + "_" + file.getOriginalFilename());
//        map.put("url", url);
//        System.out.println(JsonResult.ResultSuccess(map));
//        return JsonResult.ResultSuccess(map);
//
//    }
//
//
//    @RequestMapping("/download/websocket/{fileName}")
//    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // 保存文件到服务器的代码
//        iFileService.downloadFile(fileName,"mailFile",request,response);
//    }
}
