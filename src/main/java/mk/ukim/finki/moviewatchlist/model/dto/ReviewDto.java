package mk.ukim.finki.moviewatchlist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

  private Integer stars;
  private String description;
  private Long movie;
}
