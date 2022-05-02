package mk.ukim.finki.moviewatchlist.repository;

import mk.ukim.finki.moviewatchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    void deleteByName(String name);
//        List<Movie> findAllByGenresContaining(Genre genre);
}

