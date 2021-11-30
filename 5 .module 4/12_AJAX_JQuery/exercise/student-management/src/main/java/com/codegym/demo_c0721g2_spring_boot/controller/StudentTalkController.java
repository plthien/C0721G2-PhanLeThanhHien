package com.codegym.demo_c0721g2_spring_boot.controller;

import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkController {
    @GetMapping("/talk")
    public String getTalkList(@SessionAttribute(name = "studentTalkList")List<Student> students,
                              Model model) {
      model.addAttribute("students", students);
      return "student/list_talk";
    }
}
