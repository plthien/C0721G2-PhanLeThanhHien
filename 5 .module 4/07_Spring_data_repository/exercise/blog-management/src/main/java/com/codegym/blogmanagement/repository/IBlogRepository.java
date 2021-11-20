package com.codegym.blogmanagement.repository;

import com.codegym.blogmanagement.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, String> {

    @Query(value="select * from blog join category where blog.category_id = category.id and category.id=:id order by creation_time",nativeQuery=true)
    Page<Blog> findAllBlogByCategoryId(@Param("id") String id, Pageable pageable);


    Page<Blog> findBlogByTitleContaining(String title,Pageable pageable );
}
