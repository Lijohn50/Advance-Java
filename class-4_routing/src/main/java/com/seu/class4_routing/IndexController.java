package com.seu.class4_routing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("contact")
    public String submitForm(@RequestParam String name, @RequestParam String email, @RequestParam String message){

        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("message: " + message);

        return "contact";
    }
}
