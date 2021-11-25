package com.codegym.bookmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowingCard> borrowingCards;

    public Book() {
    }

    public Long getId() {
        return id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowingCard> getBorrowingCards() {
        return borrowingCards;
    }

    public void setBorrowingCards(List<BorrowingCard> borrowingCards) {
        this.borrowingCards = borrowingCards;
    }
}
