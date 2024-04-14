package com.example.university_project_platform_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {
//    @PostMapping("/upload")
//    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        // 保存文件到服务器的代码
//
//        // 将文件的网址存储到数据库
//        String url = "" + file.getOriginalFilename();
//        Image
//        imageRepository.save(image);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("url", url);
//        return response;
//    }
}
