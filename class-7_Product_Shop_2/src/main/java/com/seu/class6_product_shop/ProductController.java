package com.seu.class6_product_shop;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

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

        products.add(product);
        log.info("product {} has been saved", product );
        return "redirect:/product/add";
    }

    @GetMapping("list")
    public String list(Model model){

        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {

        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("product", product);

        return "form";
    }

}
