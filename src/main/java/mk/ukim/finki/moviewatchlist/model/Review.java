package mk.ukim.finki.moviewatchlist.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(5)
    @Min(0)
    private Integer stars;

    @Size(max = 4000)
    @NotNull
    private String description;

    @ManyToOne
    @NotNull
    private Movie movie;

    public Review(Integer stars, String description, Movie movie) {
        this.stars = stars;
        this.description = description;
        this.movie = movie;
    }

    public Review() {
    }
}
