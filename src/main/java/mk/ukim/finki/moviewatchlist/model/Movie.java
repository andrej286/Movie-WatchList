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

  @Enumerated(value = EnumType.STRING)
  private Genre genre;

  double score;

  @Column(length = 20000)
  private String movieImg;

  public Movie(String name, String description, Genre genre, String movieImg) {
    this.name = name;
    this.description = description;
    this.genre = genre;
    this.score = 0.0;
    this.movieImg = movieImg;
  }

  public Movie() {
  }
}
