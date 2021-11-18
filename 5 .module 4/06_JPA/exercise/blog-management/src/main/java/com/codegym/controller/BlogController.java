package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping()
    public ModelAndView showBlogs(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogs",iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message","Create new Blog successfully!");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView viewBlog(@PathVariable("id") Integer id){
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id){
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Update Blog successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id")Integer id, RedirectAttributes redirectAttributes){
        iBlogService.delete(iBlogService.findById(id));
        redirectAttributes.addFlashAttribute("message","Delete Blog successfully!");
        return "redirect:/blogs";
    }
}
