package mk.ukim.finki.moviewatchlist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Genre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
