package mk.ukim.finki.moviewatchlist.web.rest;


import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.model.dto.MovieDto;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieRestController {

  private final MovieService movieService;

  @GetMapping
  public List<Movie> findAll() {
    return this.movieService.findAll();
  }

  @GetMapping("/genres")
  private List<String> findCategories() {

    List<String> genres = new ArrayList<>();

    Arrays.stream(Genre.values()).forEach(i -> genres.add(i.name()));

    return genres;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movie> findById(@PathVariable Long id) {

    return this.movieService.findById(id)
            .map(book -> ResponseEntity.ok().body(book))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/add")
  public ResponseEntity<Movie> save(@RequestBody MovieDto movieDto) {

    return this.movieService.save(movieDto)
            .map(book -> ResponseEntity.ok().body(book))
            .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @PutMapping("/edit/{id}")
  public ResponseEntity<Movie> save(@PathVariable Long id, @RequestBody MovieDto movieDto) {

    return this.movieService.update(id, movieDto)
            .map(book -> ResponseEntity.ok().body(book))
            .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteById(@PathVariable Long id) {

    this.movieService.delete(id);
    if (this.movieService.findById(id).isEmpty()) return ResponseEntity.ok().build();
    return ResponseEntity.badRequest().build();
  }
}
