package com.example.smart_olam.dto.courses;

import java.util.List;

import com.example.smart_olam.dto.modul.ModuleRespone;

public class CoursesUpdate {
    public String courseName;
    public String status;
    public int moduleCount;
    public int duration; 
    public CoursesUpdate images;
    // public List<CourseImageResponse> images;
    public List<ModuleRespone> moduls;   
}
