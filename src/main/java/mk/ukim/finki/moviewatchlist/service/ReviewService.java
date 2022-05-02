package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.Review;

import java.util.List;

public interface ReviewService {


    List<Review> findAll();
    List<Review> findAllForMovie(Long movieId);
    Review save(Integer stars, String description, Movie movie);

}
