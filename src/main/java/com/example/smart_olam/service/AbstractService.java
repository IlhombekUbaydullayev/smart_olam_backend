package com.example.smart_olam.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

public abstract class AbstractService<R extends JpaRepository>{
    protected R repository;
    protected ObjectMapper mapper = new ObjectMapper();
    protected ModelMapper modelMapper = new ModelMapper();
    protected AbstractService(R repository) {
        this.repository = repository;
    }
    public CoursesResponse create(MultipartFile file, HttpServletRequest request, CoursesCreate create) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
}