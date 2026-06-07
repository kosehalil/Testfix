package com.kosehalil.controller;

import com.kosehalil.model.RequirementsAnalysis;
import com.kosehalil.repository.RequirementsAnalysisRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/requirementsAnalysis")
public class RequirementsAnalysisController {

    private final RequirementsAnalysisRepository repository;

    public RequirementsAnalysisController(RequirementsAnalysisRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String page(Model model) {

        model.addAttribute("requirements", repository.findAll());
        model.addAttribute("requirement", new RequirementsAnalysis());

        return "testExercises/requirementsAnalysis";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RequirementsAnalysis requirement) {

        repository.save(requirement);

        return "redirect:/requirementsAnalysis";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/requirementsAnalysis";
    }
}