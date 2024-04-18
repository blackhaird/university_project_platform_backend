package com.example.university_project_platform_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.university_project_platform_backend.entity.Credits;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService  {
    String uploadFile(MultipartFile file,  String fileLocation,String fileName) throws IOException;

    void downloadFile(String fileName,String fileLocation, HttpServletRequest request, HttpServletResponse response);
}
