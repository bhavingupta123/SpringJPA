package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder().emailId("a@gmail.com")
                .firstName("bhavin")
                .lastName("gupta")
                .guardianEmail("a")
                .guardianName("renu sandeep")
                .guardianMobile("8888")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void find(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
}