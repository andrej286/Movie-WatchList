package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {

  List<Movie> findAll();

  Optional<Movie> findById(Long id);

  Optional<Movie> save(String name, String description, Genre genre, String movieImg);

  Optional<Movie> save(MovieDto movieDto);

  void delete(Long id);

  Optional<Movie> update(Long id, String name, String description, Genre genre, String movieImg);

  Optional<Movie> update(Long id, MovieDto movieDto);
}
