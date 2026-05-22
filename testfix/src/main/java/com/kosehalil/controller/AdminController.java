package com.kosehalil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	  @GetMapping("/adminControlPanel")
	    public String adminControlPanel() {
	        return "adminControlPanel";
	    }

}
