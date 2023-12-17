package ru.cursach.internetstorebackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.cursach.internetstorebackend.services.file.FileService;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/upload")
public class UploadController {

    private FileService fileService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String uploadedPath = fileService.uploadFile(name, file);
                return new ResponseEntity<>(uploadedPath, HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
