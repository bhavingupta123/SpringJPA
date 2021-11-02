package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Course;
import com.spring.jpa2.springjpa2.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("DSA")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder() // right now saving coursematerial wont work as course is not saved , so we need to cascade it
                .url("www.a.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
}