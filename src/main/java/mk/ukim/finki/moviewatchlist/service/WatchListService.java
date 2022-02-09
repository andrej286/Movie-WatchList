package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.WatchList;

import java.util.List;

public interface WatchListService {
      List<Movie> listAllMoviesInWatchList(Long cartId);
//    WatchList addMovieToWatchList(String username, Long productId); //todo; vaka treba da e
      WatchList addMovieToWatchList(Long productId);
}
