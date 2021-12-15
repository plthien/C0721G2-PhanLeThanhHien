package com.codegym.cinemamanagement.service;

import com.codegym.cinemamanagement.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
}
