package com.example.smart_olam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Video extends AuditEntity {
    private String videoName;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "lesson_id",nullable = false)
    private Lesson lesson;
}
