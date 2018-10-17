package com.upgrad.movie.common;

import com.upgrad.movie.model.Movie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class MovieManager extends SessionManager{
        public void addMovie (Movie m) {
        Session session = openSession();
        session.save(m);
    }

    @SuppressWarnings("unchecked")
    public List<Movie> listMovies() {
        Session session = openSession();
        List<Movie> movies = session.createCriteria(Movie.class).list();
        commitSession(session);
        return movies;
    }

    public Movie getMovieById(int id) {
        Session session = openSession();
        Movie movie = (Movie) session.get(Movie.class, id);
        commitSession(session);
        return movie;
    }

    public void writeToDatabase(final Movie movie) {
        Session session = openSession();
        session.save(movie);
        commitSession(session);
    }

 /*   public void removeMovie(int id) {
        Session session = openSession();
        Query query = session.createQuery("Delete from " + Movie.class.getName() + " where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        commitSession(session);
    }
    */

}


