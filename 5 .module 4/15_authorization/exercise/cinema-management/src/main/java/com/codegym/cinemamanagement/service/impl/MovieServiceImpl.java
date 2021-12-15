package com.codegym.cinemamanagement.service.impl;

import com.codegym.cinemamanagement.model.Movie;
import com.codegym.cinemamanagement.repository.IMovieRepository;
import com.codegym.cinemamanagement.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private IMovieRepository movieRepository;


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
