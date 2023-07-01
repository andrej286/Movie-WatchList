package mk.ukim.finki.moviewatchlist.service.Impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.mapper.MovieMapper;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;
import mk.ukim.finki.moviewatchlist.repository.MovieRepository;
import mk.ukim.finki.moviewatchlist.repository.ReviewRepository;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {


  private final MovieRepository movieRepository;
  private final ReviewRepository reviewRepository;
  private final MovieMapper movieMapper;

  @Override
  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  @Override
  public Optional<Movie> findById(Long id) {

    return movieRepository.findById(id);
  }

  @Override
  public Optional<Movie> save(String name, String description, Genre genre, String movieImg) {

    return Optional.of(this.movieRepository.save(new Movie(name, description, genre, movieImg)));
  }

  @Override
  public Optional<Movie> save(MovieDto movieDto) {

    this.movieRepository.deleteByName(movieDto.getName());

    Movie movie = movieMapper.mapToMovie(movieDto);

    this.movieRepository.save(movie);

    return Optional.of(movie);
  }

  @Override
  public Optional<Movie> save(Movie movie) {

    this.movieRepository.save(movie);

    return Optional.of(movie);
  }

  @Override
  @Transactional
  public void delete(Long id) {

    this.reviewRepository.deleteAllByMovie(this.movieRepository.getById(id));

    this.movieRepository.deleteById(id);
  }

  @Override
  public Optional<Movie> update(Long id, String name, String description, Genre genre, String movieImg) {

    Movie movie = this.movieRepository.findById(id).get();

    movie.setName(name);
    movie.setDescription(description);
    movie.setGenre(genre);
    movie.setMovieImg(movieImg);

    return Optional.of(this.movieRepository.save(movie));
  }

  @Override
  public Optional<Movie> update(Long id, MovieDto movieDto) {

    Movie movie = this.movieRepository.findById(id).get();

    movie.setName(movieDto.getName());
    movie.setDescription(movieDto.getDescription());
    movie.setGenre(Genre.valueOf(movieDto.getGenre()));
    movie.setMovieImg(movieDto.getMovieImg());

    this.movieRepository.save(movie);

    return Optional.of(movie);
  }
}
