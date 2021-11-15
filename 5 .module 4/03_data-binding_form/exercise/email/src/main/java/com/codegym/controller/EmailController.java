package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.EmailServiceImpl;
import com.codegym.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class EmailController {
    private IEmailService iEmailService = new EmailServiceImpl();

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("/config-email")
    public ModelAndView showEditForm() {
        ModelAndView modelAndView = new ModelAndView("settings");
        modelAndView.addObject("email", iEmailService.findAll());

        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        modelAndView.addObject("languages", languages);

        Integer[] pageSizes = {5, 10, 15, 25, 50, 100};
        modelAndView.addObject("pageSizes", pageSizes);

        return modelAndView;
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute("email") Email email) {
        iEmailService.update(email);

        return "redirect:/";
    }


}
