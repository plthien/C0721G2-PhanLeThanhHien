package com.codegym.bookmanagement.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity(name = "borrowing_card")
public class BorrowingCard implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
            name = "book_seq",
            strategy = "com.codegym.bookmanagement.model.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = ""),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
    private String id;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    @ManyToOne(targetEntity = Student.class)
    private Student student;

    @Column(name = "date_of_borrow", columnDefinition = "DATE")
    @FutureOrPresent(message = "Date of borrow must be a date in the present or the future")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBorrow;
    @Column(name = "date_of_return", columnDefinition = "DATE")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfReturn;
    @Column(name = "status", columnDefinition = "INT DEFAULT 0")
    private int status;

    public BorrowingCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(LocalDate dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowingCard borrowingCard = (BorrowingCard) target;

        LocalDate dateOfBorrow = borrowingCard.getDateOfBorrow();
        LocalDate dateOfReturn = borrowingCard.getDateOfReturn();

        if (dateOfReturn.isBefore(dateOfBorrow)) {
            errors.rejectValue("dateOfReturn","dateOfReturn.beforeDateOfBorrow");
        }

    }
}
