package ro.fasttrackit.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.fasttrackit.project.exceptions.EntityAlreadyExistsException;
import ro.fasttrackit.project.exceptions.ResourceNotFoundException;
import ro.fasttrackit.project.model.Rating;
import ro.fasttrackit.project.entity.MovieEntity;
import ro.fasttrackit.project.entity.RatingEntity;
import ro.fasttrackit.project.repository.MovieRepository;
import ro.fasttrackit.project.repository.RatingRepository;

import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;


    public RatingService(RatingRepository repository, MovieRepository movieRepository,
                         ModelMapper modelMapper) {
        this.ratingRepository = repository;
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public RatingEntity addRating(Rating rating) {
        MovieEntity movie = getMovieEntityById(rating.getMovieId());
        validateRatingBeforeInsert(movie);
        RatingEntity ratingToBeAdded = modelMapper.map(rating, RatingEntity.class);
        ratingToBeAdded.setMovie(movie);
        return ratingRepository.save(ratingToBeAdded);
    }

    public void deleteRating(int ratingId) {
        getRatingById(ratingId);
        ratingRepository.deleteById(ratingId);
    }

    public RatingEntity updateRating(Rating rating) {
        RatingEntity ratingToUpdate = getRatingById(rating.getId());
        ratingToUpdate.setMovieRating(rating.getMovieRating());
        ratingRepository.save(ratingToUpdate);
        return ratingToUpdate;
    }

    public RatingEntity getRatingByMovieId(int movieId) {
        MovieEntity movie = getMovieEntityById(movieId);
        return ratingRepository.findByMovie(movie).orElse(
                new RatingEntity()
        );
    }

    private RatingEntity getRatingById(int id) {
        return ratingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cant find rating with id " + id));
    }

    private void validateRatingBeforeInsert(MovieEntity movie) {
        Optional<RatingEntity> rating = ratingRepository.findByMovie(movie);
        if (rating.isPresent()) {
            throw new EntityAlreadyExistsException("The movie already has a rating.");
        }
    }

    private MovieEntity getMovieEntityById(int movieId) {
        return movieRepository.findById(movieId).
                orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Movie with id %s does not exists", movieId)));
    }

}
