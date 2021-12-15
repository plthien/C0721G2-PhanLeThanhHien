package com.codegym.cinemamanagement.service;

import com.codegym.cinemamanagement.model.ShowTime;
import org.springframework.data.domain.Page;

public interface IShowTimeService {
    Page<ShowTime> findAllShowTime(int page, int size, String sortField, String sortDirection);

    Page<ShowTime> findShowTimeByMovie(int page, int size, String sortField, String sortDirection, String s);

    void saveShowTime(ShowTime showTime);

    void deleteShowTime(String id);
}
