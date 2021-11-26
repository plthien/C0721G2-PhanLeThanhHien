package com.codegym.blogmanagement.repository;

import com.codegym.blogmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

    @Query(value="select * from category",nativeQuery=true)
    List<Category> findAll();
}
