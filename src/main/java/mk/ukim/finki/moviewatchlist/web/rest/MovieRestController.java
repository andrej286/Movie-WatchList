package mk.ukim.finki.moviewatchlist.web.rest;


import mk.ukim.finki.moviewatchlist.model.Movie;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;


    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return this.movieService.findAll();
    }


//    @PostMapping("/add")
//    public ResponseEntity<Movie> save(@RequestParam String name,
//                                      @RequestParam String description){
//        //mora movieService da vrati optional od movie za da moze da go mapirash
//        List<Genre> genres = null;
//        return this.movieService.save(name, description, genres)
//                .map(movie -> ResponseEntity.ok().body(movie))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//
//    }


//    public ResponseEntity<Manufacturer> save(@RequestParam String name, @RequestParam String address) {
//        return this.manufacturerService.save(name, address)
//                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }

//    @PostMapping("/add")
//    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
//        return this.productService.save(productDto)
//                .map(product -> ResponseEntity.ok().body(product))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }

}
