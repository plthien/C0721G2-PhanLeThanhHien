package com.codegym.demo_c0721g2_spring_boot.dto;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;
import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import com.codegym.demo_c0721g2_spring_boot.utils.annotation.NameConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class StudentDTO implements Validator {
    private Integer id; //-> thuộc tính id
    @NotNull(message = "Name không được để trống ( not null")
    @NotEmpty(message = "Name không được để trống ( not empty)")
    @NotBlank(message = "Name không được để trống ( not blank")
    @NameConstraint
    @Column(name = "name")
    private String name; //-> thuộc tính name
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "Date phải đúng định dạng YYYY-mm-DD")
    @Column(name = "date_of_birth", columnDefinition = "DATE")// Kiểu dữ liệu
    private String dateOfBirth; //-> thuộc tính date_of_birth

    private Integer gender;

    private Double grade;

    private Integer classRoom;

    public Integer getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Integer classRoom) {
        this.classRoom = classRoom;
    }

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name,
                   String dateOfBirth, Integer gender, Double grade) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO student = (StudentDTO) target;
        if(!student.name.matches("[A-Za-z ]{4,}")) {
            errors.rejectValue("name","name.invalidFormat");
        }
//         if(student.grade<0) {
//             errors.rejectValue("grade","grade.min");
//        }
    }
}
