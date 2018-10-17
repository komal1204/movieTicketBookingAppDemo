package com.upgrad.movie.controller;


import com.upgrad.movie.model.Movie;
import com.upgrad.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService; //Service which will do all data retrieval/manipulation work

    // Retrieve all movies
    @RequestMapping(value = "/movies",produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listMovies() {
        List<Movie> movies = movieService.listMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    // For add and update phone both
    @RequestMapping(value = "/movie/add", method = RequestMethod.POST, consumes ="application/json")
    public ResponseEntity<Movie> createUser(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
        movieService.addMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    // For getting a reqd. phone
    @RequestMapping(value = "/movie/{id}",  method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) {

        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Movie> deleteId(@PathVariable("id") int id) {

        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        movieService.removeMovie(id);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }
    */
}
