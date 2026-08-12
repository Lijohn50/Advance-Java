package com.example.devtools_usage_tracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class DeveloperController {

    @RequestMapping("/developer")
    public String home() {
        return "developerForm";
    }
}
