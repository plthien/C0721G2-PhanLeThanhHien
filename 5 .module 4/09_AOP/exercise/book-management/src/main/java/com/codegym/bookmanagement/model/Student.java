package com.codegym.bookmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<BorrowingCard> borrowingCards;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public List<BorrowingCard> getBorrowingCards() {
        return borrowingCards;
    }

    public void setBorrowingCards(List<BorrowingCard> borrowingCards) {
        this.borrowingCards = borrowingCards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
