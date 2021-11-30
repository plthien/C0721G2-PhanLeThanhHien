package com.codegym.login.controller;

import com.codegym.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @GetMapping("/login")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("user",new User());
        return modelAndView;

    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user){
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            return new ModelAndView("/success","user",user);
        }
        return new ModelAndView("error");
    }
}
