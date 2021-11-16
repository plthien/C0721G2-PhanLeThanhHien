package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("products",productList);

        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success","Add new Product successfully!");

        return "redirect:/products";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","Edit Product successfully!");

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        iProductService.remove(id);
        redirectAttributes.addFlashAttribute("success","Delete Product successfully!");

        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewDetail(@PathVariable int id){
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product",product);
        return modelAndView;
    }




}
