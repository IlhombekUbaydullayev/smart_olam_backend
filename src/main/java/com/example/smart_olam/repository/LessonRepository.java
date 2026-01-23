package com.example.smart_olam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smart_olam.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    List<Lesson> findAllByModule_Id(Long id);
}
