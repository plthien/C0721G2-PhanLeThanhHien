package com.codegym.demo_c0721g2_spring_boot.bean;

import javax.persistence.*;

@Entity(name = "class")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_class")
    private String nameClass;

    //MappedBy phải cùng tên với thuộc tính bên class nhiều.
    // Trường hợp mà không dùng đến list như chức năng là hiển thị danh sách học sinh của 1 lớp
    // Trường hợp không sử dụng casade -> không nên khai báo @OneToMany
//    @OneToMany(mappedBy = "classRoom")
//    private List<Student> studentList;

//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }

    public ClassRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
