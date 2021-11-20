package com.codegym.blogmanagement.controller;

import com.codegym.blogmanagement.model.Category;
import com.codegym.blogmanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping()
    public ModelAndView showCategories() {
        List<Category> categories = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("category", new Category());
        redirectAttributes.addFlashAttribute("message", "Create new Category successfully!");
        return "redirect:/categories/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") String id) {
        Category category = iCategoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;

    }

    @PostMapping("/edit")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Update Category successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        iCategoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete Category successfully!");
        return "redirect:/categories";

    }
}
