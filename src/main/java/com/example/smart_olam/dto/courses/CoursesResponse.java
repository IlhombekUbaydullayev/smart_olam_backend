package com.example.smart_olam.dto.courses;


import com.example.smart_olam.dto.GenericDto;
import com.example.smart_olam.dto.courseImage.CourseImageResponse;

public class CoursesResponse extends GenericDto {
    public String courseName;
    public String status;
    public int moduleCount;
    public int duration; 
    // public List<CourseImageResponse> images;
    public CourseImageResponse images;
    // public List<ModuleRespone> moduls;
}
