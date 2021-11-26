package com.codegym.blogmanagement.controller;

import com.codegym.blogmanagement.model.Category;
import com.codegym.blogmanagement.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categories = iCategoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(categories,HttpStatus.OK );
    }

}
