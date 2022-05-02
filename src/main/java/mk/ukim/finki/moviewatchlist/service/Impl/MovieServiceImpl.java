package mk.ukim.finki.moviewatchlist.service.Impl;

import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
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
    public Movie save(String name, String description, Genre genre) {
       return movieRepository.save(new Movie(name,description,genre));
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie update(Long id, String name, String description, Genre genre) {
        Movie movie = this.findById(id).get(); //todo: add exception
        movie.setDescription(description);
        movie.setName(name);
        movie.setGenre(genre);
        return this.movieRepository.save(movie);
    }

    @Override
    public List<Movie> listMoviesByName(String name) {
        return this.findAll(); //todo: implement search filter
    }

//    @Override
//    public List<Movie> listMoviesByGenre(String genreName) {
//        Genre genre = genreRepository.findByName(genreName);
//        return movieRepository.findAllByGenresContaining(genre);
//    }

//    @Override
//    public void updateScore() {
//        movieRepository.findAll().stream().filter(i->i.getReviews()!=null).forEach(i->{
//            i.setScore(i.getReviews().stream().mapToDouble(j-> j.getStars()).average().getAsDouble());});
//    }


}
