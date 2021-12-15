package com.codegym.cinemamanagement.repository;

import com.codegym.cinemamanagement.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie,Long> {
}
