package com.example.developer_toolbox;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class ToolController {

    private final ToolService toolService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("count", toolService.count());
        return "dashboard";
    }

    @GetMapping("/tools")
    public String toolList(@RequestParam(required = false) String category, Model model) {

        if(category == null || category.isEmpty()) {

            model.addAttribute("tool", toolService.getAllTools());
        }else{

            model.addAttribute("tool", toolService.findByCategory(category));
        }
        return "tools";
    }

    @GetMapping("/form")
    public String showForm(Model model) {

        model.addAttribute("tool", new Tool());
        return "form";
    }

    @PostMapping("/form")
    public String addTool(@Valid @ModelAttribute Tool tool, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {

            return "form";
        }
        toolService.saveTool(tool);
        return "redirect:/home/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {

        Tool tool = toolService.EditToolById(id);

        model.addAttribute("tool", tool);

        return "form";
    }

    @PostMapping("/edit/{id}")
    public String editTool(@Valid @ModelAttribute Tool tool, @PathVariable int id){


        toolService.editTool(tool, id);
        return "redirect:/home/form";
    }

    @GetMapping("/tools/{id}")
    public String deleteTool(@PathVariable int id) {

        toolService.deleteTool(id);
        return "redirect:/home/tools";
    }

    @GetMapping("/license")
    public String showLicense(Model model) {

        model.addAttribute("toolLicense", new ToolLicense());
        return "onetoone";
    }

    @PostMapping("/license")
    public String addLicense(@ModelAttribute ToolLicense toolLicense) {

        System.out.println("hello from tool" + toolLicense.getLicenseType());
        toolService.saveLicense(toolLicense);
        return "redirect:/home/license";
    }
}
