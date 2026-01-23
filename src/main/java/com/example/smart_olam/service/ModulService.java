package com.example.smart_olam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.smart_olam.dto.modul.ModuleCreate;
import com.example.smart_olam.dto.modul.ModulePubRespone;
import com.example.smart_olam.dto.modul.ModuleRespone;
import com.example.smart_olam.dto.modul.ModuleUpdate;
import com.example.smart_olam.mapper.ModulMapper;
import com.example.smart_olam.model.Course;
import com.example.smart_olam.model.Modul;
import com.example.smart_olam.repository.CourseRepository;
import com.example.smart_olam.repository.ModulRepository;

@Service
public class ModulService extends AbstractService<ModulRepository> implements GenericService<
   ModuleRespone,ModuleUpdate,ModuleCreate,Long>{

    private final ModulMapper mapper;
    private final CourseRepository courseRepository;

    protected ModulService(ModulRepository repository,ModulMapper mapper,CourseRepository courseRepository) {
        super(repository);
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        
    }

    @Override
    public ModuleRespone create(ModuleCreate createDto) {
        Course course = courseRepository.findById(createDto.courseId).get();
        Modul module = mapper.fromCreateDto(createDto);
        module.setCourse(course);
        Modul save = repository.save(module);
        return mapper.toDto(save);
    }

    @Override
    public ModuleRespone update(ModuleUpdate updateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public ModuleRespone get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Transactional(readOnly = true)
    @Override
    public List<ModuleRespone> getAll() {
        // mapper.toDto(repository.findAll())
        return mapper.toDto(repository.findAllByCourse_Id(1L));   
    }

    @Transactional(readOnly = true) 
    public List<ModuleRespone> getAllByCourseId(Long courseId){
        return mapper.toDto(repository.findAllByCourse_Id(courseId));
    }

     @Transactional(readOnly = true) 
    public List<ModulePubRespone> getAllPubByCourseId(Long courseId){
        return mapper.toPubDto(repository.findAllByCourse_Id(courseId));
    }
    
}
