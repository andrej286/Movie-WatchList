package mk.ukim.finki.moviewatchlist.service.Impl;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;
import mk.ukim.finki.moviewatchlist.repository.MovieRepository;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {


  private final MovieRepository movieRepository;

  public MovieServiceImpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }


  @Override
  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  @Override
  public Optional<Movie> findById(Long id) {

    return movieRepository.findById(id);
  }

  @Override
  public Optional<Movie> save(String name, String description, Genre genre) {

    return Optional.of(this.movieRepository.save(new Movie(name, description, genre)));
  }

  @Override
  public Optional<Movie> save(MovieDto movieDto) {

    this.movieRepository.deleteByName(movieDto.getName());

    Movie movie = new Movie(movieDto.getName(), movieDto.getDescription(), Genre.valueOf(movieDto.getGenre()));

    this.movieRepository.save(movie);

    return Optional.of(movie);
  }

  @Override
  public void delete(Long id) {

    this.movieRepository.deleteById(id);
  }

  @Override
  public Optional<Movie> update(Long id, String name, String description, Genre genre) {

    Movie movie = this.movieRepository.findById(id).get();

    movie.setName(name);
    movie.setDescription(description);
    movie.setGenre(genre);

    return Optional.of(this.movieRepository.save(movie));
  }

  @Override
  public Optional<Movie> update(Long id, MovieDto movieDto) {

    Movie movie = this.movieRepository.findById(id).get();

    movie.setName(movieDto.getName());
    movie.setDescription(movieDto.getDescription());
    movie.setGenre(Genre.valueOf(movieDto.getGenre()));

    this.movieRepository.save(movie);

    return Optional.of(movie);
  }
}
