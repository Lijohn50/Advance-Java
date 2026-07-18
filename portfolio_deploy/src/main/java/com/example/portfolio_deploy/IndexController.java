package com.example.portfolio_deploy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(){

        return "index";
    }

    @PostMapping("message")
    public String submitMessage(@ModelAttribute Message message){

        log.info("Message: {}", message);
        return "index";
    }
}
