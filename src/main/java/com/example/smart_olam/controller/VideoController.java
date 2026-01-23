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

import com.example.smart_olam.dto.video.VideoCreate;
import com.example.smart_olam.dto.video.VideoResponse;
import com.example.smart_olam.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/video")
public class VideoController {

    private final VideoService service;
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VideoCreate create){
        VideoResponse response = service.create(create);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<VideoResponse>> getAll(@PathVariable Long id){
        return ResponseEntity.ok(service.getAllByModuleId(id));
    }

}
