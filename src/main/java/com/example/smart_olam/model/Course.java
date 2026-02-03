package com.example.smart_olam.model;

import java.util.List;


import com.example.smart_olam.enums.Status;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AuditEntity {
    private String courseName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    private int moduleCount;
    private int duration;

    // @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    // private List<CourseImage> images;
    @OneToOne
    private Image images;

    private boolean isDeleted = false;
    
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Modul> moduls;
    
}
