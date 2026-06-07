package com.kosehalil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kosehalil.repository.CourseVideoRepository;

@Controller
public class CourseController {

    private final CourseVideoRepository videoRepository;

    public CourseController(CourseVideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/courses/{courseName}")
    public String coursePage(@PathVariable String courseName, Model model) {

        var videos = videoRepository
                .findByCourse_NameIgnoreCaseOrderByLessonOrderAsc(courseName);

        model.addAttribute("videos", videos);
        model.addAttribute("courseName", courseName);

        return "courses/selenium";
    }
    

}