package com.example.smart_olam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.example.smart_olam.dto.courses.CoursesUpdate;
import com.example.smart_olam.model.Course;

@Mapper(componentModel = "spring",uses = ModulMapper.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper extends BaseMapper<
         Course,
         CoursesResponse,
         CoursesCreate,
         CoursesUpdate> {
    
}
