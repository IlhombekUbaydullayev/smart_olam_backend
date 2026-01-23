package com.example.smart_olam.dto.courses;

import java.util.List;

import com.example.smart_olam.dto.GenericDto;
import com.example.smart_olam.dto.modul.ModuleRespone;

public class CoursesResponse extends GenericDto {
    public String courseName;
    public String status;
    public int moduleCount;
    public int duration; 
    // public List<CourseImageResponse> images;
    public String images;
    // public List<ModuleRespone> moduls;
}
