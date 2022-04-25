package ro.fasttrackit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.entity.MovieEntity;
import ro.fasttrackit.project.entity.RatingEntity;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {
    Optional<RatingEntity> findByMovie(MovieEntity movie);
    Optional<RatingEntity> findById(int id);
}
