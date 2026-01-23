package com.example.smart_olam.dto.modul;

import java.util.List;

import com.example.smart_olam.dto.GenericDto;
import com.example.smart_olam.dto.lesson.LessonPubResponse;

public class ModulePubRespone extends GenericDto {
   public String modulName;
   public String price; 
   public Long courseId;
   public List<LessonPubResponse> lessons;
}
