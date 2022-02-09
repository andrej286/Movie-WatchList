package mk.ukim.finki.moviewatchlist.config;


import lombok.Getter;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.service.GenreService;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    private final MovieService movieService;
    private final GenreService genreService;
    private final ReviewService reviewService;

    public DataHolder(MovieService movieService, GenreService genreService, ReviewService reviewService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void initData() {

        genreService.save("COMEDY");
        genreService.save("ROMANCE");
        genreService.save("ACTION");

        List<Genre> testGenres = new ArrayList<>();
        testGenres.add(genreService.findByName("COMEDY"));

        Movie movie1 = movieService.save("Pirates of the Caribbean", "legendary", testGenres);
        Movie movie2 = movieService.save("The Dark Knight", "awesome",genreService.findAll());

        reviewService.save(4,"dali si be ti normalen", movie1);
        reviewService.save(1,"e ja mislam ne si", movie1);
        reviewService.save(4,"a ovoj be", movie2);




    }
}
