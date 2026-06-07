package com.kosehalil.controller;

import com.kosehalil.model.User;
import com.kosehalil.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        User user = authService.login(username, password);

        if (user == null) {
            return "redirect:/login?error";
        }

        session.setAttribute("loggedUser", user.getUsername());

        if ("Halil".equalsIgnoreCase(user.getUsername())
                && "Admin1234".equals(user.getPassword())) {

            session.setAttribute("role", "ADMIN");
            return "redirect:/adminControlPanel";
        }
        session.setAttribute("role", "USER");

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}