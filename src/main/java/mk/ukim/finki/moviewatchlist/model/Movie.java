package mk.ukim.finki.moviewatchlist.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

//  @Column(length = 4000)
  @Size(max = 4000)
  @NotNull
  private String description;

  @Enumerated(value = EnumType.STRING)
  private Genre genre;

  @Max(5)
  @Min(0)
  double score;

//  @Column(length = 20000)
  @Size(max = 20000)
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
