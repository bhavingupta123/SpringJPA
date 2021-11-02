package com.spring.jpa2.springjpa2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// course and course_material have 1 to 1 relationship

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long CourseId;
    private String title;
    private int credit;

    @OneToOne(
            mappedBy = "course" // bi direction relationship telling joined by course in courseMaterial
    )
    private CourseMaterial courseMaterial;
}
