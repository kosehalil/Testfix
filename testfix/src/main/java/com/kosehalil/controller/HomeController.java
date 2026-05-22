package com.kosehalil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }
    
    @GetMapping("/testExercise")
    public String testExercise() {
        return "testExercise";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @GetMapping("/errorPage")
    public String errorPage() {
    	return "errorPage";
    }
    
    @GetMapping("/testExercises/tooltip")
    public String tooltip() {
    	return "testExercises/tooltip";
    }
    
    @GetMapping("/testExercises/loginTest")
    public String loginTest() {
    	return "testExercises/loginTest";
    }
    
    @GetMapping("/testExercises/dragAndDropAction")
    public String dragAndDropAction() {
    	return "testExercises/dragAndDropAction";
    }
    
    @GetMapping("/testExercises/popup")
    public String popup() {
    	return "testExercises/popup";
    }
    
    @GetMapping("/testExercises/apiTest")
    public String apiTest() {
    	return "testExercises/apiTest";
    }
    
    @GetMapping("/testExercises/uploadDownload")
    public String uploadDownload() {
    	return "testExercises/uploadDownload";
    }
    
    
}
