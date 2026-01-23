package com.example.smart_olam.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.smart_olam.dto.video.VideoCreate;
import com.example.smart_olam.dto.video.VideoResponse;
import com.example.smart_olam.dto.video.VideoUpdate;
import com.example.smart_olam.model.Video;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VideoMapper extends BaseMapper<
    Video,
    VideoResponse,
    VideoCreate,
    VideoUpdate 
> {

    @Mapping(source = "lesson.id", target = "lessonId")
    VideoResponse toDto(Video video);

    List<VideoResponse> toDto(List<Video> videos);
}