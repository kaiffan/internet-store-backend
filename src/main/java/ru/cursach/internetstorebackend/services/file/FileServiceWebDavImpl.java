package ru.cursach.internetstorebackend.services.file;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceWebDavImpl implements FileService {

    String fileServerUrl = "http://25.33.65.57:5050/product_images/";

    @Override
    @Async
    public String uploadFile(String name, MultipartFile file) throws IOException {
        Sardine sardine = SardineFactory.begin();
        sardine.put(fileServerUrl + name, file.getInputStream());
        return fileServerUrl + name;
    }
}
