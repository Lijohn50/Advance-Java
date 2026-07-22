package com.seu.class6_product_shop;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/add")
    public String showForm(Model model){

        model.addAttribute("name", "java");
        model.addAttribute("product", new Product());

        return "form";
    }

    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult){

        log.info("product {} has been submitted", product);

        if(bindingResult.hasErrors()){

            return "form";
        }
        return "redirect:/product/add";
    }
}
