package com.example.spring.project2.repositories;

import com.example.spring.project2.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {
}
