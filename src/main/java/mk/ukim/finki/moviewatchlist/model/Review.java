package mk.ukim.finki.moviewatchlist.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stars;

    private String description;

    @ManyToOne
    private Movie movie;

    public Review(Integer stars, String description, Movie movie) {
        this.stars = stars;
        this.description = description;
        this.movie = movie;
    }

    public Review() {
    }
}
