package com.seu.class4_routing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage(){

        return "index";
    }

    @GetMapping("contact")
    public String contactPage(){

        return "contact";
    }

    @PostMapping("submit")
    public String submitForm(@ModelAttribute Contact contact){

        log.info("contact form submitted {}", contact);
        System.out.println(contact);
        return "redirect:/contact";
    }

    @GetMapping("student")
    public String studentPage(){

        return "student";
    }
    @PostMapping("student-submit")
    public String studentForm(@ModelAttribute Student student){

        log.info("Submit student form {}", student);
        System.out.println(student);
        return "redirect:/";
    }
}
