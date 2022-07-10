package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

  List<Review> findAll();

  Review save(Integer stars, String description, Movie movie);

  Optional<Review> findById(Long id);

  Optional<Review> save(ReviewDto reviewDto);

  void delete(Long id);
}
