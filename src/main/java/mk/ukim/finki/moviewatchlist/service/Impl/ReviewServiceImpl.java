package mk.ukim.finki.moviewatchlist.service.Impl;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;
import mk.ukim.finki.moviewatchlist.repository.MovieRepository;
import mk.ukim.finki.moviewatchlist.repository.ReviewRepository;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;
  private final MovieRepository movieRepository;

  public ReviewServiceImpl(ReviewRepository reviewRepository, MovieRepository movieRepository) {
    this.reviewRepository = reviewRepository;
    this.movieRepository = movieRepository;
  }

  @Override
  public List<Review> findAll() {
    return this.reviewRepository.findAll();
  }

  @Override
  public List<Review> findAllForMovie(Long movieId) {

    Movie movie = this.movieRepository.findById(movieId).get();

    return this.reviewRepository.findByMovie(movie);
  }

  @Override
  public Review save(Integer stars, String description, Movie movie) {

    return this.reviewRepository.save(new Review(stars, description, movie));
  }

  @Override
  public Optional<Review> findById(Long id) {
    return reviewRepository.findById(id);
  }

  @Override
  public Optional<Review> save(ReviewDto reviewDto) {

    Movie movie = movieRepository.findById(reviewDto.getMovie()).get();

    Review review = new Review(reviewDto.getStars(), reviewDto.getDescription(), movie);

    this.reviewRepository.save(review);

    return Optional.of(review);
  }

  @Override
  public void delete(Long id) {

    this.reviewRepository.deleteById(id);
  }
}
