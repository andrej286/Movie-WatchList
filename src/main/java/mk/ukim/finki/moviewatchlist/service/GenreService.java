package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> findAll();
    Optional<Genre> findById(Long id);
    Genre save(String name);
    Genre findByName(String name);
}
