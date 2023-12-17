package ru.cursach.internetstorebackend.services.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(String name, MultipartFile path) throws IOException;
}
