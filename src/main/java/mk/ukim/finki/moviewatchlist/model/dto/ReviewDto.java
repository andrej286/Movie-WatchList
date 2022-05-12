package mk.ukim.finki.moviewatchlist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDto {

  private Integer stars;
  private String description;
  private Long movie;
}
