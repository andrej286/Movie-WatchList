package mk.ukim.finki.moviewatchlist.repository;

import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.User;
import mk.ukim.finki.moviewatchlist.model.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchListRepository extends JpaRepository<WatchList, Long> {
    Optional<WatchList> findByUser(User user);
}
