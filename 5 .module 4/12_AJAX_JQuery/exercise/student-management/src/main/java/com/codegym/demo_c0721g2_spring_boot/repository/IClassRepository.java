package com.codegym.demo_c0721g2_spring_boot.repository;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
