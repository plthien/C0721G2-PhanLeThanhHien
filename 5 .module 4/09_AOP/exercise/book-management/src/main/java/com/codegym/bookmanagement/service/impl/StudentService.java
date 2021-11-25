package com.codegym.bookmanagement.service.impl;

import com.codegym.bookmanagement.model.Student;
import com.codegym.bookmanagement.repository.IStudentRepository;
import com.codegym.bookmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> findAllStudent() {
        return iStudentRepository.findAll();
    }
}
