package com.spring.jpa2.springjpa2.repository;

import com.spring.jpa2.springjpa2.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
