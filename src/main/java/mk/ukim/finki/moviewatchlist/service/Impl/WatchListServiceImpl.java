package mk.ukim.finki.moviewatchlist.service.Impl;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.WatchList;
import mk.ukim.finki.moviewatchlist.repository.WatchListRepository;
import mk.ukim.finki.moviewatchlist.service.WatchListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListServiceImpl implements WatchListService {


    private final WatchListRepository watchListRepository;

    public WatchListServiceImpl(WatchListRepository watchListRepository) {
        this.watchListRepository = watchListRepository;
    }

    @Override
    public List<Movie> listAllMoviesInWatchList(Long cartId) {
        return watchListRepository.findById(cartId).get().getMovies();
    }

//    @Override   //todo; vaka treba da e
//    public WatchList addMovieToWatchList(String username, Long productId) {
//        return null;
//    }

    @Override
    public WatchList addMovieToWatchList(Long movieId) {

//        WatchList watchList = this.watchListRepository.sa

        return null;
    }


}
