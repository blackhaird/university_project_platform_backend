package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.entity.Mail;
import com.example.university_project_platform_backend.service.IFileService;
import com.example.university_project_platform_backend.service.IWebSocketServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    IFileService iFileService;
    @Autowired
    IWebSocketServer iWebSocketServer;
    @PostMapping("/sendForUserList")
    public JsonResult<Map<String, Object>> sendForUserList(@RequestBody Mail mail ){
        System.out.println(mail.toString());
        mail.setMailTime(LocalDateTime.now());
        Map<String,Object> keys =iWebSocketServer.sendMailMessageForUserList(mail);
        return JsonResult.ResultSuccess(keys);
    }
    @PostMapping("/getMessage")
    public JsonResult<Map<String, Object>> sendForAll(@RequestBody Mail mail){
        Map<String,Object> keys =iWebSocketServer.getMailUserMap(mail);
        System.out.println(keys.size());
        return JsonResult.ResultSuccess(keys);
    }

    @RequestMapping("/upload/{fileLocation}")
    public JsonResult<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file,
                                                      @PathVariable("fileLocation") String fileLocation) throws IOException {
        // 保存文件到服务器的代码
        Map<String,Object> map = new HashMap<>();
        String url = iFileService.uploadFile(file,fileLocation , UUID.randomUUID().toString().substring(0, 10) + "_" +
                file.getOriginalFilename());
        map.put("url", url);
        System.out.println(JsonResult.ResultSuccess(map));
        return JsonResult.ResultSuccess(map);
    }


    @RequestMapping("/download/{fileLocation}/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, @PathVariable("fileLocation")
    String fileLocation,HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 保存文件到服务器的代码
        iFileService.downloadFile(fileName,fileLocation,request,response);
    }


}
