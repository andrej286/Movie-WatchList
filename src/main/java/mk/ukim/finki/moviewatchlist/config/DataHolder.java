package mk.ukim.finki.moviewatchlist.config;


import lombok.Getter;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {
    private final MovieService movieService;
    private final ReviewService reviewService;

    public DataHolder(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void initData() {

        Movie movie1 = movieService.save("Pirates of the Caribbean", "legendary", Genre.ACTION);
        Movie movie2 = movieService.save("The Dark Knight", "awesome",Genre.COMEDY);

        reviewService.save(4,"dali si be ti normalen", movie1);
        reviewService.save(1,"e ja mislam ne si", movie1);
        reviewService.save(4,"a ovoj be", movie2);




    }
}
