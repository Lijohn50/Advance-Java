package com.example.devtools_usage_tracker.controller;

import com.example.devtools_usage_tracker.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @GetMapping("/form")
    public String login() {
        return "login";
    }
    @PostMapping("/form")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {

        if(loginService.checkAdmin(username, password)){

            return "redirect:/home/dashboard";
        }else{

            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
