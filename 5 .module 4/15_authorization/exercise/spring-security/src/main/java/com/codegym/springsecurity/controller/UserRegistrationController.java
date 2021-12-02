package com.codegym.springsecurity.controller;

import com.codegym.springsecurity.dto.UserRegistrationDto;
import com.codegym.springsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @ModelAttribute("userDTO")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping()
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String saveUser(@Valid @ModelAttribute("userDTO") UserRegistrationDto userRegistrationDto,
                           BindingResult bindingResult,
                           Model model) {
        if (iUserService.findByEmail(userRegistrationDto.getEmail()) != null) {
            bindingResult.addError(new FieldError("user", "email",
                    "Your email already exists!"));
        }

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getRPassword())) {
            bindingResult.addError(new FieldError("user", "rPassword",
                    "Re-enter password must match with password!"));
        }

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("userDTO", userRegistrationDto);
            return "registration";
        }

        String password = bCryptPasswordEncoder.encode(userRegistrationDto.getPassword());
        userRegistrationDto.setPassword(password);
        iUserService.saveRegistrationUser(userRegistrationDto);

        return "redirect:/registration?success";

    }

}

