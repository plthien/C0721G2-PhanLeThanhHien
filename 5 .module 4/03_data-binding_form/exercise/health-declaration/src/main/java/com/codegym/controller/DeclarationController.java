package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DeclarationController {

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping("/declare")
    public ModelAndView showDeclareForm(){

    }
}
