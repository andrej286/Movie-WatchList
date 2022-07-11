package mk.ukim.finki.moviewatchlist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

  @NotNull
  private String name;

  @Size(max = 4000)
  @NotNull
  private String description;

  @NotNull
  private String genre;

  @Max(5)
  @Min(0)
  private double score;

  @Size(max = 20000)
  private String movieImg;
}
