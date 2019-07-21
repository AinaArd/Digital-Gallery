package ru.itis.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class FileDownloader {

    private static String uploadedFolder;

    public Optional<String> upload(MultipartFile image, String photoName) {
        if (!image.isEmpty()) {
            String photoFolderName = photoName + "\\";
            File directory = new File(uploadedFolder + photoFolderName);
            if (!directory.exists()) directory.mkdirs();
            String fileName = photoFolderName + image.getOriginalFilename();
            Path path = Paths.get(uploadedFolder + fileName);
            try {
                byte[] bytes = image.getBytes();
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Optional.of(fileName);
        } else {
            return Optional.empty();
        }
    }

    @Value("${my.files.url}")
    public void setUploadedFolder(String uploadedFolder) {
        FileDownloader.uploadedFolder = uploadedFolder;
    }

    public static String getUploadedFolder() {
        return uploadedFolder;
    }
}