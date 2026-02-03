package com.example.smart_olam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.smart_olam.exceptions.FileUploadException;
import com.example.smart_olam.model.Image;
import com.example.smart_olam.repository.ImageRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${image.upload-dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;

    public Image upload(MultipartFile file, HttpServletRequest request) {

        validate(file);

        try {
            Files.createDirectories(Paths.get(uploadDir));

            String storedName = UUID.randomUUID() + getExtension(file.getOriginalFilename());
            Path path = Paths.get(uploadDir, storedName);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            String url = buildUrl(request, storedName);

            Image image = Image.builder()
                    .originalName(file.getOriginalFilename())
                    .storedName(storedName)
                    .filePath(path.toString())
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .url(url)
                    .build();

            return imageRepository.save(image);

        } catch (IOException e) {
            throw new FileUploadException("File saqlashda xatolik");
        }
    }

    public Resource load(String storedName) {
        try {
            Path path = Paths.get(uploadDir).resolve(storedName);
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists()) {
                throw new FileNotFoundException();
            }

            return resource;
        } catch (Exception e) {
            throw new FileUploadException("Rasm topilmadi");
        }
    }

    /* ================== PRIVATE ================== */

    private void validate(MultipartFile file) {
        if (file.isEmpty())
            throw new FileUploadException("File bo‘sh");

        if (!file.getContentType().startsWith("image/"))
            throw new FileUploadException("Faqat rasm yuklash mumkin");
    }

    private String getExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    private String buildUrl(HttpServletRequest request, String storedName) {
        return request.getScheme() + "://" +
                request.getServerName() + ":" +
                request.getServerPort() +
                "/api/images/view/" + storedName;
    }
}
