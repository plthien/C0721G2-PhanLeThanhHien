package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String showCheckBox(){
        return "list";
    }

    @GetMapping("/condiments")
    public String showResult(@RequestParam String[] condiment, Model model){
        model.addAttribute("condimentList",condiment);
        return "result";
    }
}
