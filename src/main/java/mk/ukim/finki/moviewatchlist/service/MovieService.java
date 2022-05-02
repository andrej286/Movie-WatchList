package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    Movie save(String name, String description, Genre genre);
    void delete(Long id);
    Movie update(Long id, String name,String description, Genre genre);
    List<Movie> listMoviesByName(String name);
//    List<Movie> listMoviesByGenre(String name);
//    void updateScore();
}
