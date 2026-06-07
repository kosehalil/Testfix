package com.kosehalil.controller;

import com.kosehalil.model.TestScenario;
import com.kosehalil.repository.TestScenarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testExercise")
public class TestScenarioController {

    private final TestScenarioRepository repository;

    public TestScenarioController(TestScenarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String scenarioPage(Model model) {

        model.addAttribute("scenario", new TestScenario());
        model.addAttribute("scenarios", repository.findAll());

        return "testExercises/testScenario";
    }

    @PostMapping("/save")
    public String saveScenario(TestScenario scenario) {

        repository.save(scenario);

        return "redirect:/testExercise";
    }

    @GetMapping("/delete/{id}")
    public String deleteScenario(@PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/testExercise";
    }
}