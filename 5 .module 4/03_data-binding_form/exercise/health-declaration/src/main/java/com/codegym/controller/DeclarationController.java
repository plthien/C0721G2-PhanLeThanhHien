package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value = "declaration")
@RequestMapping("/")
public class DeclarationController {
    @Qualifier("declarationServiceImpl")
    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping("/declare")
    public ModelAndView showDeclareForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("declaration",new Declaration());

        String [] genders = {"Male","Female"};
        modelAndView.addObject("genders",genders);

        String[] nationalities = {"Viet Nam", "Mỹ", "Canada","Anh"};
        modelAndView.addObject("nationalities",nationalities);

        String[] vehicles = {"Tàu bay","Tàu thuyền","Ô tô","Khác"};
        modelAndView.addObject("vehicles",vehicles);

        String[] cities = {"Đà Nẵng","Hà Nội","Huế"};
        modelAndView.addObject("cities",cities);

        String[] districts = {"Sơn Trà","Hải Châu","Thanh Khê","Liên Chiểu","Cẩm Lệ","Hòa Vang"};
        modelAndView.addObject("districts",districts);

        String[] communes = {"Mân Thái","Thọ Quang","An Hải Bắc"};
        modelAndView.addObject("communes",communes);

        return modelAndView ;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("declaration") Declaration declaration, RedirectAttributes redirectAttributes){
        iDeclarationService.saveDeclaration(declaration);

        redirectAttributes.addFlashAttribute("mess","Khai báo thành công");
        return "redirect:/";
    }

    @PostMapping("/declaration")
    public ModelAndView editDeclaration(@RequestParam String idCard){
        Declaration declaration = iDeclarationService.findByIdCard(idCard);
        if (declaration != null){
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("declaration",declaration);
            String [] genders = {"Male","Female"};
            modelAndView.addObject("genders",genders);

            String[] nationalities = {"Viet Nam", "Mỹ", "Canada","Anh"};
            modelAndView.addObject("nationalities",nationalities);

            String[] vehicles = {"Tàu bay","Tàu thuyền","Ô tô","Khác"};
            modelAndView.addObject("vehicles",vehicles);

            String[] cities = {"Đà Nẵng","Hà Nội","Huế"};
            modelAndView.addObject("cities",cities);

            String[] districts = {"Sơn Trà","Hải Châu","Thanh Khê","Liên Chiểu","Cẩm Lệ","Hòa Vang"};
            modelAndView.addObject("districts",districts);

            String[] communes = {"Mân Thái","Thọ Quang","An Hải Bắc"};
            modelAndView.addObject("communes",communes);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("mess","Khong tim thay");
            return modelAndView;
        }

    }
}
