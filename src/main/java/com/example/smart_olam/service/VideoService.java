package com.example.smart_olam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.smart_olam.dto.video.VideoCreate;
import com.example.smart_olam.dto.video.VideoResponse;
import com.example.smart_olam.dto.video.VideoUpdate;
import com.example.smart_olam.mapper.VideoMapper;
import com.example.smart_olam.model.Lesson;
import com.example.smart_olam.model.Video;
import com.example.smart_olam.repository.LessonRepository;
import com.example.smart_olam.repository.VideoRepository;

@Service
public class VideoService extends AbstractService<VideoRepository> implements GenericService<
 VideoResponse,VideoUpdate,VideoCreate,Long>{

    private final VideoMapper mapper;
    private final LessonRepository lessonRepository;

    protected VideoService(VideoRepository repository,VideoMapper mapper,LessonRepository lessonRepository) {
        super(repository);
        this.mapper = mapper;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public VideoResponse create(VideoCreate createDto) {
        Lesson lesson = lessonRepository.findById(createDto.lessonId).get();
        Video video = mapper.fromCreateDto(createDto);
        video.setLesson(lesson);
        Video save = repository.save(video);
        return mapper.toDto(save);
    }

    @Override
    public VideoResponse update(VideoUpdate updateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Long delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VideoResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<VideoResponse> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Transactional(readOnly = true) 
    public List<VideoResponse> getAllByModuleId(Long lessonId){
        return mapper.toDto(repository.findAllByLesson_Id(lessonId));
    }
    
}
