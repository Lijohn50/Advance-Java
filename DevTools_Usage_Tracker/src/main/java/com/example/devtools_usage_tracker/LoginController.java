package com.example.devtools_usage_tracker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }
    @GetMapping("/form")
    public String form(Model model) {

        model.addAttribute("tool", new Tool());
        return "form";
    }
}
