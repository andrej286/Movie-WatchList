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

  public Movie(String name, String description, Genre genre) {
    this.name = name;
    this.description = description;
    this.genre = genre;
    this.score = 0.0;
  }

  public Movie() {
  }
}
