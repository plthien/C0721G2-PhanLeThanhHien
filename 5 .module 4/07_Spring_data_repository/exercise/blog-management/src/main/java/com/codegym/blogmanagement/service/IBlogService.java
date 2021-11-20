package com.codegym.blogmanagement.service;

import com.codegym.blogmanagement.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(String id);

    void delete(Blog blog);

    Page<Blog> findAllBlogByCategoryId(String id, Pageable pageable);

    Page<Blog> findAllBlogByTitle(String title, Pageable pageable);
}
