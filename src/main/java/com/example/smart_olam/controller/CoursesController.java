 
package com.example.smart_olam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.smart_olam.dto.courses.CoursesCreate;
import com.example.smart_olam.dto.courses.CoursesResponse;
import com.example.smart_olam.service.CoursesService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor

public class CoursesController {

    public final CoursesService service;

   @PostMapping(
    value = "/create",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
)
public ResponseEntity<?> create(
        @RequestPart("file") MultipartFile file,
        @RequestPart("course") CoursesCreate coursesCreate,
        HttpServletRequest request
) {
    CoursesResponse response = service.create(coursesCreate, file, request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

    @GetMapping("/getAll")
    public ResponseEntity<List<CoursesResponse>> getAll() {
        List<CoursesResponse> courses = service.getAll();
        return ResponseEntity.ok(courses);
    } 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    
}