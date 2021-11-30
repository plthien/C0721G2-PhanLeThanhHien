package com.codegym.demo_c0721g2_spring_boot.service;


import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import com.codegym.demo_c0721g2_spring_boot.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(int idStudent);

    void save(Student student);

    List<Student> searchByName(String name);

    //Pageable -> Giúp các bạn sort, lấy được số phần tử của 1 trang
    // cũng như lấy số trang.
    Page<Student> findAll(Pageable pageable);

    void saveDTO(StudentDTO student);
}
