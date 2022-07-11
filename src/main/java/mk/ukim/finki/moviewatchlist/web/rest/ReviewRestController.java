package mk.ukim.finki.moviewatchlist.web.rest;


import lombok.RequiredArgsConstructor;
import mk.ukim.finki.moviewatchlist.model.Review;
import mk.ukim.finki.moviewatchlist.model.dto.ReviewDto;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

  private final ReviewService reviewService;

  @GetMapping
  public List<Review> findReviews() {
    return this.reviewService.findAll();
  }

  @PostMapping("/add")
  public ResponseEntity<Review> save(@Valid @RequestBody ReviewDto reviewDto) {

    return this.reviewService.save(reviewDto)
            .map(book -> ResponseEntity.ok().body(book))
            .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteById(@PathVariable Long id) {

    this.reviewService.delete(id);
    if (this.reviewService.findById(id).isEmpty()) return ResponseEntity.ok().build();
    return ResponseEntity.badRequest().build();
  }
}
