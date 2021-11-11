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
    public String convert(@RequestParam("usd") String usd, @RequestParam("rate") String rate , Model model) {
        double usdD = Double.parseDouble(usd);
        double rateD = Double.parseDouble(rate);
        double vnd = usdD* rateD;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usdD);
        return "home";

    }

}
