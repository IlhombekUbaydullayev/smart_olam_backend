package com.example.smart_olam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.smart_olam.dto.lesson.LessonCreate;
import com.example.smart_olam.dto.lesson.LessonPubResponse;
import com.example.smart_olam.dto.lesson.LessonResponse;
import com.example.smart_olam.dto.lesson.LessonUpdate;
import com.example.smart_olam.model.Lesson;

@Mapper(componentModel = "spring",uses = VideoMapper.class,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LessonMapper extends BaseMapper<
    Lesson,
    LessonResponse,
    LessonCreate,
    LessonUpdate 
> {

    @Mapping(source = "module.id", target = "moduleId")
    LessonResponse toDto(Lesson lesson);

    List<LessonResponse> toDto(List<Lesson> lessons);

    List<LessonPubResponse> toPubDto(List<Lesson> lessons);
}