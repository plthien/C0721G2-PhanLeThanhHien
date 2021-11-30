package com.codegym.demo_c0721g2_spring_boot.service.impl;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;
import com.codegym.demo_c0721g2_spring_boot.repository.IClassRepository;
import com.codegym.demo_c0721g2_spring_boot.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository iClassRepository;

    @Override
    public List<ClassRoom> findAll() {
        return iClassRepository.findAll();
    }
}
