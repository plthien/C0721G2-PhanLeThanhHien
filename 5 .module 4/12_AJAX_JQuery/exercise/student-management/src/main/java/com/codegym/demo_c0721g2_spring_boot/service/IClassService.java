package com.codegym.demo_c0721g2_spring_boot.service;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;

import java.util.List;

public interface IClassService {
    List<ClassRoom> findAll();
}
