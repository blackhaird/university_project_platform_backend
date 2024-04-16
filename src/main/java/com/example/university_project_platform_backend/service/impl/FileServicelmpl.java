package com.example.university_project_platform_backend.service.impl;


import com.example.university_project_platform_backend.service.IFileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
@Service
public class FileServicelmpl implements IFileService {
    private static final String DOMAIN = "http://localhost:8408/file/download/";
    private static final String STORE_PATH = "D:\\Work_RJ\\java_study\\university_project_platform_backend\\src\\main\\resources\\picture\\";

    @Override
    public String uploadFile(MultipartFile file, String fileName) throws IOException {
        InputStream is = file.getInputStream();
        FileUtils.copyInputStreamToFile(is, new java.io.File(STORE_PATH + fileName));

        String url = DOMAIN + fileName;
        System.out.println(url);
        return url;
    }

    @Override
    public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response) {
        String filePath = STORE_PATH + fileName;
        System.out.println(filePath);
        try {
            response.setContentType(MediaType.APPLICATION_ATOM_XML_VALUE);
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
            Files.copy(new File(filePath).toPath(), response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
