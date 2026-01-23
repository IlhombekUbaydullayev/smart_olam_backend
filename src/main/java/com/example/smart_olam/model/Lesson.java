package com.example.smart_olam.model;

import java.util.List;

import com.example.smart_olam.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Lesson extends AuditEntity {
    private String lessonName;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "module_id",nullable = false)
    private Modul module;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos;
}
