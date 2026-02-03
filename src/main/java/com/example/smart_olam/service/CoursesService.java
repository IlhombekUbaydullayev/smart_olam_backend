package com.example.smart_olam.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.example.smart_olam.dto.courses.CoursesUpdate;
import com.example.smart_olam.exceptions.FileUploadException;
import com.example.smart_olam.mapper.CourseMapper;
import com.example.smart_olam.model.Course;
import com.example.smart_olam.model.Image;
import com.example.smart_olam.repository.CourseRepository;
import com.example.smart_olam.repository.ImageRepository;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class CoursesService extends AbstractService<CourseRepository> implements GenericService<
        CoursesResponse,CoursesUpdate,CoursesCreate,Long> {

        private final CourseMapper courseMapper;
        private final ImageRepository imageRepository;

        @Value("${image.upload-dir}")
        private String uploadDir;
        
        protected CoursesService(CourseRepository repository,CourseMapper courseMapper,ImageRepository imageRepository){
            super(repository);
            this.courseMapper = courseMapper;
            this.imageRepository = imageRepository;
        }

        @Override
        public CoursesResponse create(CoursesCreate create) {
            Course course = courseMapper.fromCreateDto(create);
            
            Course save = repository.save(course);
            return courseMapper.toDto(save);
        }


        public CoursesResponse create(CoursesCreate create,MultipartFile file,HttpServletRequest request) {
            Course course = courseMapper.fromCreateDto(create);
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
                    Image image2 = imageRepository.save(image);
                    course.setImages(image2);
                     Course save = repository.save(course);
                     return courseMapper.toDto(save);
        } catch (IOException e) {
            throw new FileUploadException("File saqlashda xatolik");
        }
        }

        @Override
        public CoursesResponse update(CoursesUpdate update){
            return null;
        }

        @Override
        public Long delete(Long id){
            Course course = repository.findById(id).get();
            course.setDeleted(true);
            repository.save(course);
            return id;
        }

        @Override
        public CoursesResponse get(Long id){
            return null;
        }

        @Transactional(readOnly = true)
        @Override
        public List<CoursesResponse> getAll(){
            return courseMapper.toDto(repository.findAllByIsDeletedFalse());
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
