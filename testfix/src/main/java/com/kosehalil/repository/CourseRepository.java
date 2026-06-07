package com.kosehalil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosehalil.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
}