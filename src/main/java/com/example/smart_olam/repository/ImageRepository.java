package com.example.smart_olam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smart_olam.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

