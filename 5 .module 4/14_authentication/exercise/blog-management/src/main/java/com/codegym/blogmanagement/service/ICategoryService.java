package com.codegym.blogmanagement.service;

import com.codegym.blogmanagement.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(String id);

    void deleteById(String id);
}
