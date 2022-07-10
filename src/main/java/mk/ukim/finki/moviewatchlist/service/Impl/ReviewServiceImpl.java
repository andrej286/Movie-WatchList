package mk.ukim.finki.moviewatchlist.service.Impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.mapper.ReviewMapper;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;
import mk.ukim.finki.moviewatchlist.repository.ReviewRepository;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;
  private final ReviewMapper reviewMapper;

  @Override
  public List<Review> findAll() {
    return this.reviewRepository.findAll();
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

    Review review = reviewMapper.mapToReview(reviewDto);

    this.reviewRepository.save(review);

    return Optional.of(review);
  }

  @Override
  public void delete(Long id) {

    this.reviewRepository.deleteById(id);
  }
}
