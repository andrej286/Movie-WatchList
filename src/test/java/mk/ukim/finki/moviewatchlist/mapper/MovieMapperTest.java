package mk.ukim.finki.moviewatchlist.mapper;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieMapperTest {

  private static final String movieName = "movieName";
  private static final String movieDescription = "movieDescription";
  private static final String movieGenre = "COMEDY";
  private static final String movieImg = "movieImg";
  private static final double score = 5.0;

  @InjectMocks
  private MovieMapper mapperUnderTest;

  @Test
  void shouldMapToMovie() {

    // Given
    MovieDto movieDtoMock = mockMovieDto();

    // When
    Movie result = mapperUnderTest.mapToMovie(movieDtoMock);

    // Then
    checkMovieResult(result);
  }

  @Test
  void shouldMapToMovieDto() {

    // Given
    Movie movieMock = mockMovie();

    // When
    MovieDto result = mapperUnderTest.mapToMovieDto(movieMock);

    // Then
    checkMovieDtoResult(result);
  }

  private Movie mockMovie(){

    Movie movieMock = mock(Movie.class);

    Genre genre = Genre.valueOf(movieGenre);

    when(movieMock.getName()).thenReturn(movieName);
    when(movieMock.getDescription()).thenReturn(movieDescription);
    when(movieMock.getGenre()).thenReturn(genre);
    when(movieMock.getScore()).thenReturn(score);
    when(movieMock.getMovieImg()).thenReturn(movieImg);

    return movieMock;
  }

  private MovieDto mockMovieDto() {

    MovieDto movieDtoMock = mock(MovieDto.class);

    when(movieDtoMock.getName()).thenReturn(movieName);
    when(movieDtoMock.getDescription()).thenReturn(movieDescription);
    when(movieDtoMock.getGenre()).thenReturn(movieGenre);
    when(movieDtoMock.getScore()).thenReturn(score);
    when(movieDtoMock.getMovieImg()).thenReturn(movieImg);

    return movieDtoMock;
  }

  private void checkMovieDtoResult(MovieDto movieDto){

    Assertions.assertEquals(movieName, movieDto.getName());
    Assertions.assertEquals(movieDescription, movieDto.getDescription());
    Assertions.assertEquals(movieGenre, movieDto.getGenre());
    Assertions.assertEquals(score, movieDto.getScore());
    Assertions.assertEquals(movieImg, movieDto.getMovieImg());
  }


  private void checkMovieResult(Movie movie) {

    Assertions.assertEquals(movieName, movie.getName());
    Assertions.assertEquals(movieDescription, movie.getDescription());
    Assertions.assertEquals(Genre.valueOf(movieGenre), movie.getGenre());
    Assertions.assertEquals(score, movie.getScore());
    Assertions.assertEquals(movieImg, movie.getMovieImg());
  }
}
/*
@ExtendWith(MockitoExtension.class)
class MovieMapperTest {

  private static final String movieName = "movieName";
  private static final String movieDescription = "movieDescription";
  private static final String movieGenre = "COMEDY";
  private static final String movieImg = "movieImg";
  private static final int score = 0;

  @InjectMocks
  private MovieMapper mapperUnderTest;

  @Test
  void shouldMapToMovie() {

    // Given
    MovieDto movieDtoMock = mockMovieDto();

    // When
    Movie result = mapperUnderTest.mapToMovie(movieDtoMock);

    // Then
    checkMovieResult(result);
  }

  @Test
  void shouldMapToMovieDto() {

    // Given
    double score = 5.0;

    Movie movieMock = mockMovie(score);

    // When
    MovieDto result = mapperUnderTest.mapToMovieDto(movieMock);

    // Then
    checkMovieDtoResult(result, score);
  }

  private Movie mockMovie(double score){

    Movie movieMock = mock(Movie.class);

    Genre genre = Genre.valueOf(movieGenre);

    when(movieMock.getName()).thenReturn(movieName);
    when(movieMock.getDescription()).thenReturn(movieDescription);
    when(movieMock.getGenre()).thenReturn(genre);
    when(movieMock.getScore()).thenReturn(score);
    when(movieMock.getMovieImg()).thenReturn(movieImg);

    return movieMock;
  }

  private MovieDto mockMovieDto() {

    MovieDto movieDtoMock = mock(MovieDto.class);

    when(movieDtoMock.getName()).thenReturn(movieName);
    when(movieDtoMock.getDescription()).thenReturn(movieDescription);
    when(movieDtoMock.getGenre()).thenReturn(movieGenre);
    when(movieDtoMock.getMovieImg()).thenReturn(movieImg);

    return movieDtoMock;
  }

  private void checkMovieDtoResult(MovieDto movieDto, double score){

    Assertions.assertEquals(movieName, movieDto.getName());
    Assertions.assertEquals(movieDescription, movieDto.getDescription());
    Assertions.assertEquals(movieGenre, movieDto.getGenre());
    Assertions.assertEquals(score, movieDto.getScore());
    Assertions.assertEquals(movieImg, movieDto.getMovieImg());
  }


  private void checkMovieResult(Movie movie) {

    Assertions.assertEquals(movieName, movie.getName());
    Assertions.assertEquals(movieDescription, movie.getDescription());
    Assertions.assertEquals(Genre.valueOf(movieGenre), movie.getGenre());
    Assertions.assertEquals(movieImg, movie.getMovieImg());
  }
}
 */