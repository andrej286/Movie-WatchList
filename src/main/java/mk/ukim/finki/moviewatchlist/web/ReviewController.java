package mk.ukim.finki.moviewatchlist.web;


import mk.ukim.finki.moviewatchlist.model.Genre;
import mk.ukim.finki.moviewatchlist.service.MovieService;
import mk.ukim.finki.moviewatchlist.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final MovieService movieService;

    public ReviewController(ReviewService reviewService, MovieService movieService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String listR(@PathVariable Long id,
                         HttpServletRequest req,
                         Model model) {
        req.getSession().setAttribute("movieId", id);
        model.addAttribute("reviews", reviewService.findAllForMovie(id));
        model.addAttribute("movie", movieService.findById(id).get());
        return "listReview";
    }
    @GetMapping
    public String listRTwo(HttpServletRequest req,Model model) {
        Long id = (Long) req.getSession().getAttribute("movieId");
        model.addAttribute("reviews", reviewService.findAllForMovie(id));
        model.addAttribute("movie", movieService.findById(id).get());
        return "listReview";
    }

    @GetMapping("/add/{id}")
    public String showAdd(@PathVariable Long id,
                          Model model) {
        model.addAttribute("movie", movieService.findById(id).get());
        return "addReview";
    }

    @PostMapping
    public String create(@RequestParam Integer stars,
                         @RequestParam String description,
                         HttpServletRequest req,
                         Model model) {
        Long id = (Long) req.getSession().getAttribute("movieId");
        this.reviewService.save(stars,description,this.movieService.findById(id).get());
        return "redirect:/review";
    }

}
