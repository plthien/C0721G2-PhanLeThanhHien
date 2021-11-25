package com.codegym.furamaresortmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roleName;

    @ManyToMany(targetEntity = User.class)
    private List<User> userList;

    public Role() {
    }

    public Role(int id, String roleName, List<User> userList) {
        this.id = id;
        this.roleName = roleName;
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
