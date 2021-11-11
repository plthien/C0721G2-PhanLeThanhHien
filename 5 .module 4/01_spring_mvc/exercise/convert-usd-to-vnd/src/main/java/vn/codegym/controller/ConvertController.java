package vn.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("")
    public String showHome(){
        return "home";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam double usd, @RequestParam double rate , Model model) {
        double vnd = usd* rate;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "home";

    }

}
