package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    public List<Student> findByFirstName(String firstName); // custom method

    //JPQL query
    @Query("select s from Student s where s.emailId= ?1") // based on class and attribute
    Student getStudentByEmailAddress(String email);

}
