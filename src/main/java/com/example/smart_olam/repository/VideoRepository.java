package com.example.smart_olam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smart_olam.model.Video;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findAllByLesson_Id(Long id);
}

