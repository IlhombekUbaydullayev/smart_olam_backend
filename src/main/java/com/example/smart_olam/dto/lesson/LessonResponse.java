package com.example.smart_olam.dto.lesson;

import java.util.List;

import com.example.smart_olam.dto.GenericDto;
import com.example.smart_olam.dto.video.VideoResponse;

public class LessonResponse extends GenericDto {
    public String lessonName;
    public Long moduleId;
    public List<VideoResponse> videos;
}
