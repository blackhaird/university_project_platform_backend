package com.example.university_project_platform_backend.controller;

import com.example.university_project_platform_backend.common.JsonResult;
import com.example.university_project_platform_backend.service.IFileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    IFileService iFileService;

    @RequestMapping("/upload")
    public JsonResult<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        // 保存文件到服务器的代码
        Map<String,Object> map = new HashMap<>();
        String url = iFileService.uploadFile(file, UUID.randomUUID().toString().substring(0, 10) + "_" + file.getOriginalFilename());
        map.put("url", url);
        System.out.println(JsonResult.ResultSuccess(map));
        return JsonResult.ResultSuccess(map);

    }


    @RequestMapping("/download/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 保存文件到服务器的代码
        iFileService.downloadFile(fileName,request,response);

    }

}
