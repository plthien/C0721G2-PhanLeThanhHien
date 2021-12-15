package com.codegym.demo.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 100)
    @Column(name = "title",columnDefinition = "VARCHAR(100)")
    private String title;
    @NotBlank
    @Size(min = 10, max = 500)
    @Column(name = "content",columnDefinition = "VARCHAR(500)")
    private String content;
    private String answer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_create", columnDefinition = "DATE")
    private LocalDate dateCreate;
    @ManyToOne(targetEntity = QuestionType.class)
    private QuestionType questionType;
    @Column(name = "status" , columnDefinition = "INT DEFAULT 0")
    private int status;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setStatus() {
        if (this.answer.equals("")) {
            this.status = 0;
        } else {
            this.status = 1;
        }
    }
}
