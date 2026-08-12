package com.example.devtools_usage_tracker.controller;

import com.example.devtools_usage_tracker.model.Admin;
import com.example.devtools_usage_tracker.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

    private final SignupService signupService;

    @GetMapping("/form")
    public String signUpForm(Model model) {

        model.addAttribute("admin", new Admin());
        return "signUp";
    }
    @PostMapping("/form")
    public String signUpPost(@ModelAttribute Admin admin) {

        IO.println(admin.getUsername());
        signupService.saveAdmin(admin);
        return "redirect:/home/login";
    }
}
