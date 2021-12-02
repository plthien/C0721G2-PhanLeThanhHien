package com.codegym.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "employee")
@NoArgsConstructor @AllArgsConstructor @Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToOne(targetEntity = AppUser.class)
    private AppUser appUser;

}
