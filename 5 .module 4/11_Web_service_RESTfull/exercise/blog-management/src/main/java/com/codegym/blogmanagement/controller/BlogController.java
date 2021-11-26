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

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping()
    public ResponseEntity<List<Blog>> findAllBlogs() {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable String id){
        Blog blog = iBlogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategoryId(@PathVariable String id){
        List<Blog> blogs = iBlogService.findAllBlogByCategoryId(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }





}
