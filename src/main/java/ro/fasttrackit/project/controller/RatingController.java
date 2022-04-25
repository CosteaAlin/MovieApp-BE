package ro.fasttrackit.project.controller;


import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.project.model.Rating;
import ro.fasttrackit.project.entity.RatingEntity;
import ro.fasttrackit.project.service.RatingService;

@RestController
@RequestMapping("rating")
public class RatingController {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @GetMapping
    RatingEntity getRatingByMovieId(@RequestParam(required = true) int movieId){
        return service.getRatingByMovieId(movieId);
    }

    @PostMapping
    RatingEntity addRating(@RequestBody Rating rating) {
        return service.addRating(rating);
    }

    @DeleteMapping
    void deleteRating(@RequestParam(required = true) int ratingId) {
        service.deleteRating(ratingId);
    }

    @PutMapping
    RatingEntity updateRating(@RequestBody Rating rating) {
        return service.updateRating(rating);
    }
}
