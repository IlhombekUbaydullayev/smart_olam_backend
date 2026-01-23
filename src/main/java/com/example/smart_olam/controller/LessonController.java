package com.example.smart_olam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smart_olam.dto.lesson.LessonCreate;
import com.example.smart_olam.dto.lesson.LessonPubResponse;
import com.example.smart_olam.dto.lesson.LessonResponse;
import com.example.smart_olam.service.LessonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lesson")
public class LessonController {

    private final LessonService service;
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LessonCreate create){
        LessonResponse response = service.create(create);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<LessonResponse>> getAll(@PathVariable Long id){
        return ResponseEntity.ok(service.getAllByModuleId(id));
    }


    @GetMapping("/getAll/pub/{id}")
    public ResponseEntity<List<LessonPubResponse>> getAllPub(@PathVariable Long id){
        return ResponseEntity.ok(service.getAllPubByModuleId(id));
    }

}
