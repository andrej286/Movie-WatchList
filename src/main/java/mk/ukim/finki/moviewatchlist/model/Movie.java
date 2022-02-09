package mk.ukim.finki.moviewatchlist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4000)
    private String description;

    @ManyToMany
    private List<Genre> genres;

//    @OneToMany(mappedBy = "movie")
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    private List<Review> reviews;

    public Movie(String name, String description,List<Genre> genres) {
        this.name = name;
        this.description = description;
        this.genres=genres;
    }

    public Movie() {
    }
}
