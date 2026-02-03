package com.example.smart_olam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.smart_olam.dto.courseImage.CourseImageResponse;
import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.example.smart_olam.dto.courses.CoursesUpdate;
import com.example.smart_olam.model.Course;
import com.example.smart_olam.model.Image;

@Mapper(componentModel = "spring",uses = ModulMapper.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper extends BaseMapper<
         Course,
         CoursesResponse,
         CoursesCreate,
         CoursesUpdate> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "url", target = "url")
    CourseImageResponse imageToCourseImageResponse(Image image); 
    
    @Mapping(source = "images", target = "images")
    CoursesResponse toDto(Course course);
}
