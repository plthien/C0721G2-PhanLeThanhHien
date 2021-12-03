package com.codegym.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserLoginController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal){

        return "profile";
    }
}
