package mk.ukim.finki.moviewatchlist.mapper;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  public Movie mapToMovie(MovieDto movieDto){

    Movie movie = new Movie();
    // TODO: 7/12/2022 check to see if adding setScore to Movie will break something
    movie.setName(movieDto.getName());
    movie.setDescription(movieDto.getDescription());
    movie.setGenre(Genre.valueOf(movieDto.getGenre()));
    movie.setScore(movieDto.getScore());
    movie.setMovieImg(movieDto.getMovieImg());

    return movie;
  }

  public MovieDto mapToMovieDto(Movie movie) {

    MovieDto movieDto = new MovieDto();

    Genre genre = movie.getGenre();

    movieDto.setName(movie.getName());
    movieDto.setDescription(movie.getDescription());
    movieDto.setGenre(genre.toString());
    movieDto.setScore(movie.getScore());
    movieDto.setMovieImg(movie.getMovieImg());

    return movieDto;
  }
}
