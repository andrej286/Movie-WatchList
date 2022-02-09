package mk.ukim.finki.moviewatchlist.web;


import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.service.GenreService;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = {"/", "/movies"})
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @GetMapping
    public String getMoviePage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "listMovies";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("genres" , this.genreService.findAll());
        return "addMovie";
    }

    @PostMapping("/")
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam List<Long> genres,
                         Model model) {
        List<Genre> genres1 = new ArrayList<>();
        genres.forEach(i->genres1.add(genreService.findById(i).get()));
        this.movieService.save(name,description,genres1);
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id}")
    @Transactional
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("movie", this.movieService.findById(id).get());
        model.addAttribute("genres" , this.genreService.findAll());
        return "addMovie";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam List<Long> genres,
                         Model model) {
        this.movieService.update(id, name,description, genres);
        return "redirect:/movies";
    }

    @PostMapping("/{id}/delete")
    @Transactional
    public String delete(@PathVariable Long id,
                         Model model) {
        this.movieService.delete(id);
        return "redirect:/movies";
    }


}
