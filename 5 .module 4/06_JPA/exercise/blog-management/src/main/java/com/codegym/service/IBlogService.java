package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.UUID;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(UUID id);

    void delete(Blog blog);

}
