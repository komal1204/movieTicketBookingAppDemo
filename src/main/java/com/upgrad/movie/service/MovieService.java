package com.upgrad.movie.service;

import com.upgrad.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MovieService")
public interface MovieService {
    public void addMovie(Movie movie);
    public List<Movie> listMovies();
    public Movie getMovieById(int id);
    // public void removeMovie(int id);
}
