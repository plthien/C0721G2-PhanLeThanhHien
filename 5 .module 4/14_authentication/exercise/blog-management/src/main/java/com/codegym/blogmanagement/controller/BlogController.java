package com.codegym.blogmanagement.controller;

import com.codegym.blogmanagement.model.Blog;
import com.codegym.blogmanagement.model.Category;
import com.codegym.blogmanagement.service.IBlogService;
import com.codegym.blogmanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return iCategoryService.findAll();
    }

    @GetMapping()
    public String viewPage(Model model){
        Sort sort = Sort.by("creationTime").ascending();
        int pageSize = 5;
        model.addAttribute("blogs", iBlogService.findAll(PageRequest.of(0, pageSize, sort)));
        return "blog/list";
    }

    @GetMapping("/{page}")
    public String loadMoreBlogs(@PathVariable(value = "page") int page,
                                        Model model) {
        Sort sort = Sort.by("creationTime").ascending();
        int pageSize = 5;
        Page<Blog> blogs = iBlogService.findAll(PageRequest.of(page, pageSize, sort));
        model.addAttribute("blogs",blogs.getContent());
        return "blog/search";

    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        LocalDateTime localDateTime = LocalDateTime.now();
        blog.setCreationTime(localDateTime);
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new Blog successfully!");
        redirectAttributes.addFlashAttribute("blog", new Blog());
        return "redirect:/blogs/create";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailBlog(@PathVariable("id") String id) {
        return new ModelAndView("/blog/detail", "blog", iBlogService.findById(id));

    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        iBlogService.delete(iBlogService.findById(id));
        redirectAttributes.addFlashAttribute("message", "Delete Blog successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") String id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Update Blog successfully!");
        return modelAndView;
    }

    @GetMapping("/search/{title}")
    public String searchBlog(@PathVariable("title") String title,
                             Model model) {
        model.addAttribute("blogs", iBlogService.findAllBlogByTitle(title));
        model.addAttribute("title", title);
        return "blog/search";
    }

}
