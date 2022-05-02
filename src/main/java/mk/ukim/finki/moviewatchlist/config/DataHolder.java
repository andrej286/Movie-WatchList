package mk.ukim.finki.moviewatchlist.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@RequiredArgsConstructor
public class DataHolder {
  private final MovieService movieService;
  private final ReviewService reviewService;

  @PostConstruct
  public void initData() {

    Movie movie1 = movieService.save("Pirates of the Caribbean", "legendary", Genre.ACTION).get();
    Movie movie2 = movieService.save("The Dark Knight", "awesome", Genre.COMEDY).get();

    reviewService.save(4, "dali ova raboti", movie1);
    reviewService.save(1, "place holder 1", movie1);
    reviewService.save(4, "place holder 2", movie2);
  }
}
