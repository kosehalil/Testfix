package com.kosehalil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosehalil.model.CourseVideo;

@Repository
public interface CourseVideoRepository extends JpaRepository<CourseVideo, Long> {

	List<CourseVideo> findByCourse_NameIgnoreCaseOrderByLessonOrderAsc(String name);
}
