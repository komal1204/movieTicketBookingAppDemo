package com.upgrad.movie.service;

import com.upgrad.movie.common.MovieManager;
import com.upgrad.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import com.upgrad.movie.common.MovieManager;
import com.upgrad.movie.model.Movie;
import com.upgrad.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("MovieService")
public class MovieServiceImp implements MovieService {

    private MovieManager movieManager;

    public MovieServiceImp() {
        movieManager = new MovieManager();
    }

    @Override
    public void addMovie(Movie m) {
        movieManager.writeToDatabase(m);
    }

    @Override
    public List<Movie> listMovies() {
        return movieManager.listMovies();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieManager.getMovieById(id);
    }

    /*
    @Override
    public void removeMovie(int id) {
        movieManager.removeMovie(id);
    }
    */

}




