package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class CalculatorController {

    @GetMapping("")
    public String showCalculator(){
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String numberOne, @RequestParam String numberTwo, @RequestParam String operator, Model model){
        String result = "";
        try {
            double a = Double.parseDouble(numberOne);
            double b = Double.parseDouble(numberTwo);
            switch (operator){
                case "+":
                    result +="Result Addition:" + (a + b);
                    break;
                case "-":
                    result +="Result Subtraction: " + (a - b);
                    break;
                case "X":
                    result +="Result Multiplication: " + (a * b);
                    break;
                default:
                    if (b ==0 ){
                        result +="Cannot divide by zero";
                    } else {
                        result +="Result Division:" + (a/b);
                    }
                    break;

            }

        } catch (NumberFormatException e){
            result +="It's not a number";
        }

        model.addAttribute("result",result);
        model.addAttribute("numberOne",numberOne);
        model.addAttribute("numberTwo",numberTwo);
        return "index";
    }
}
