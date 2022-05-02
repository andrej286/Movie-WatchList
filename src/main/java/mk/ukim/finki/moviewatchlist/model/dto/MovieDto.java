package mk.ukim.finki.moviewatchlist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDto {

  private String name;
  private String description;
  private String genre;
  private double score;
}
