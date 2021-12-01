package com.codegym.blogmanagement.controller;


import com.codegym.blogmanagement.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/login")
    public String loginPage() {
        return "/home/loginPage";
    }

    @GetMapping("/userInfo")
    public String userInfo(Model model, Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);

        return "home/userInfoPage";
    }
}
