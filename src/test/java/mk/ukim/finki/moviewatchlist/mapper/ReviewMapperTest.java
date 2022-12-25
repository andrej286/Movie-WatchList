package mk.ukim.finki.moviewatchlist.mapper;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;
import mk.ukim.finki.moviewatchlist.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewMapperTest {

  private static final Integer stars = 5;
  private static final String description = "description";

  @Mock
  private MovieRepository movieRepository;

  @InjectMocks
  private ReviewMapper mapperUnderTest;

  @Test
  void shouldMapToReview() {

    // Given
    Movie movieMock = mock(Movie.class);

    ReviewDto reviewDtoMock = mockReviewDto(movieMock);

    // When
    Review result = mapperUnderTest.mapToReview(reviewDtoMock);

    // Then
    checkReviewResult(result, movieMock);
  }

  @Test
  void shouldMapToReviewDto() {

    // Given
    Long movieId = 1L;

    Review reviewMock = mockReview(movieId);

    // When
    ReviewDto result = mapperUnderTest.mapToReviewDto(reviewMock);

    // Then
    checkReviewDtoResult(result, movieId);
  }

  private Review mockReview(Long movieId){

    Movie movieMock = mock(Movie.class);

    Review reviewMock = mock(Review.class);

    when(movieMock.getId()).thenReturn(movieId);

    when(reviewMock.getStars()).thenReturn(stars);
    when(reviewMock.getDescription()).thenReturn(description);
    when(reviewMock.getMovie()).thenReturn(movieMock);

    return reviewMock;
  }

  private ReviewDto mockReviewDto(Movie movie){

    ReviewDto reviewDtoMock = mock(ReviewDto.class);

    when(movieRepository.findById(anyLong())).thenReturn(Optional.ofNullable(movie));

    when(reviewDtoMock.getStars()).thenReturn(stars);
    when(reviewDtoMock.getDescription()).thenReturn(description);

    return reviewDtoMock;
  }

  private void checkReviewDtoResult(ReviewDto reviewDto, Long movieId){

    Assertions.assertEquals(stars, reviewDto.getStars());
    Assertions.assertEquals(description, reviewDto.getDescription());
    Assertions.assertEquals(movieId, reviewDto.getMovie());
  }

  private void checkReviewResult(Review review, Movie movie){

    Assertions.assertEquals(stars, review.getStars());
    Assertions.assertEquals(description, review.getDescription());
    Assertions.assertEquals(movie, review.getMovie());

    verify(movieRepository, times(1)).findById(anyLong());
  }
}