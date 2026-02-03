package com.example.smart_olam.dto.courses;

import com.example.smart_olam.dto.BaseDto;
import com.example.smart_olam.enums.Status;

public class CoursesCreate implements BaseDto {
    public String courseName;
    public Status status = Status.ACTIVE;
    public int moduleCount;
    public int duration;
}
