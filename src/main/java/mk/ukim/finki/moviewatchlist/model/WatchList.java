package mk.ukim.finki.moviewatchlist.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class WatchList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Movie> movies;

    public WatchList(User user) {
        this.user = user;
        this.movies = new ArrayList<>();
    }

    public WatchList() {
    }
}
