package com.example.smart_olam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.smart_olam.dto.lesson.LessonCreate;
import com.example.smart_olam.dto.lesson.LessonPubResponse;
import com.example.smart_olam.dto.lesson.LessonResponse;
import com.example.smart_olam.dto.lesson.LessonUpdate;
import com.example.smart_olam.dto.modul.ModuleRespone;
import com.example.smart_olam.mapper.LessonMapper;
import com.example.smart_olam.model.Lesson;
import com.example.smart_olam.model.Modul;
import com.example.smart_olam.repository.LessonRepository;
import com.example.smart_olam.repository.ModulRepository;

@Service
public class LessonService extends AbstractService<LessonRepository> implements GenericService<
 LessonResponse,LessonUpdate,LessonCreate,Long>{

    private final LessonMapper mapper;
    private final ModulRepository moduleRepository;

    protected LessonService(LessonRepository repository,LessonMapper mapper,ModulRepository modulRepository) {
        super(repository);
        this.mapper = mapper;
        this.moduleRepository = modulRepository;
    }

    @Override
    public LessonResponse create(LessonCreate createDto) {
        Modul module = moduleRepository.findById(createDto.moduleId).get();
        Lesson lesson = mapper.fromCreateDto(createDto);
        lesson.setModule(module);
        Lesson save = repository.save(lesson);
        return mapper.toDto(save);
    }

    @Override
    public LessonResponse update(LessonUpdate updateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Long delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LessonResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<LessonResponse> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Transactional(readOnly = true) 
    public List<LessonResponse> getAllByModuleId(Long moduleId){
        return mapper.toDto(repository.findAllByModule_Id(moduleId));
    }

    @Transactional(readOnly = true) 
    public List<LessonPubResponse> getAllPubByModuleId(Long moduleId){
        return mapper.toPubDto(repository.findAllByModule_Id(moduleId));
    }
    
}
