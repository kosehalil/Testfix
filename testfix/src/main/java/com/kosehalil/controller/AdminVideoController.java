package com.kosehalil.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kosehalil.model.Course;
import com.kosehalil.model.CourseVideo;
import com.kosehalil.repository.CourseRepository;
import com.kosehalil.repository.CourseVideoRepository;

@Controller
public class AdminVideoController {

    private final CourseVideoRepository videoRepository;
    private final CourseRepository courseRepository;

    public AdminVideoController(CourseVideoRepository videoRepository,
                                CourseRepository courseRepository) {
        this.videoRepository = videoRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/admin/videos")
    public String videosPage(Model model) {

        model.addAttribute("videos", videoRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());

        return "admin/videos";
    }

    @PostMapping("/admin/videos/add")
    public String addVideo(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Integer lessonOrder,
            @RequestParam Long courseId,
            @RequestParam MultipartFile videoFile) throws IOException {

        String uploadDir = "C:/testfix-videos/";

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName =
                UUID.randomUUID() + "_" + videoFile.getOriginalFilename();

        Files.copy(
                videoFile.getInputStream(),
                uploadPath.resolve(fileName)
        );

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseVideo video = new CourseVideo();
        video.setTitle(title);
        video.setDescription(description);
        video.setLessonOrder(lessonOrder);
        video.setFileName(fileName);
        video.setCourse(course);

        videoRepository.save(video);

        return "redirect:/admin/videos";
    }

    @PostMapping("/admin/videos/delete/{id}")
    public String delete(@PathVariable Long id) {

        videoRepository.deleteById(id);

        return "redirect:/admin/videos";
    }
}