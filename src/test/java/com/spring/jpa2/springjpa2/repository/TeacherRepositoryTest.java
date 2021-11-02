package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Course;
import com.spring.jpa2.springjpa2.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course course = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Bhavin")
                .lastName("g")
                .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
}