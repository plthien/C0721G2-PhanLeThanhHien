package com.codegym.blogmanagement.service;

import com.codegym.blogmanagement.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(String id);

    void delete(Blog blog);

    List<Blog> findAllBlogByCategoryId(String id);

    Page<Blog> findAllBlogByTitle(String title, Pageable pageable);
}
