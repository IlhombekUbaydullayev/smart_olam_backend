package com.example.smart_olam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.example.smart_olam.dto.courses.CoursesUpdate;
import com.example.smart_olam.mapper.CourseMapper;
import com.example.smart_olam.model.Course;
import com.example.smart_olam.repository.CourseRepository;



@Service
public class CoursesService extends AbstractService<CourseRepository> implements GenericService<
        CoursesResponse,CoursesUpdate,CoursesCreate,Long> {

        private final CourseMapper courseMapper;
        
        protected CoursesService(CourseRepository repository,CourseMapper courseMapper){
            super(repository);
            this.courseMapper = courseMapper;
        }

        @Override
        public CoursesResponse create(CoursesCreate create) {
            Course course = courseMapper.fromCreateDto(create);
            Course save = repository.save(course);
            return courseMapper.toDto(save);
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

}
