package com.example.smart_olam.model;

import java.util.ArrayList;
import java.util.List;

import com.example.smart_olam.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Modul extends AuditEntity {
    private String modulName;
    private String price;

    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    @JsonIgnore
    private Course course;

     @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;
    
}
