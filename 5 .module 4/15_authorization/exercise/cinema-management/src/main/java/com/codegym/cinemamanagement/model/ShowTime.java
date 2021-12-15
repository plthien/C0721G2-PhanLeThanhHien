package com.codegym.cinemamanagement.model;

import com.codegym.cinemamanagement.customid.CustomIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity(name = "show_time")
public class ShowTime implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facility_seq")
    @GenericGenerator(
            name = "facility_seq",
            strategy = "com.codegym.cinemamanagement.customid.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "CI-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    private String id;
    @ManyToOne(targetEntity = Movie.class)
    private Movie movie;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Column(name = "date_of_show", columnDefinition = "DATETIME")
    private LocalDateTime dateOfShow;
    @Column(name = "number_of_ticket")
    @Min(value = 0,message = "Invalid Number of Ticket: Number of Ticket must greater than 0 !")
    private Long numberOfTicket;
    @Column(name = "status", columnDefinition = "INT DEFAULT 1")
    private Integer status;

    public ShowTime() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getDateOfShow() {
        return dateOfShow;
    }

    public void setDateOfShow(LocalDateTime dateOfShow) {
        this.dateOfShow = dateOfShow;
    }

    public Long getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(Long numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ShowTime showTime = (ShowTime) target;
        LocalDateTime dateOfShow = showTime.getDateOfShow();

        if (dateOfShow.isBefore(LocalDateTime.now())){
            errors.rejectValue("dateOfShow","dateOfShow.past");
        }
    }
}
