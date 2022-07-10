package mk.ukim.finki.moviewatchlist.mapper;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;
import mk.ukim.finki.moviewatchlist.repository.MovieRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

  private final MovieRepository movieRepository;

  public Review mapToReview(ReviewDto reviewDto){

    Review review = new Review();

    Movie movie = movieRepository.findById(reviewDto.getMovie()).get();

    review.setStars(reviewDto.getStars());
    review.setDescription(reviewDto.getDescription());
    review.setMovie(movie);

    return review;
  }

  public ReviewDto mapToReviewDto(Review review){

    ReviewDto reviewDto = new ReviewDto();

    Movie movie = review.getMovie();

    reviewDto.setStars(review.getStars());
    reviewDto.setDescription(review.getDescription());
    reviewDto.setMovie(movie.getId());

    return reviewDto;
  }
}
