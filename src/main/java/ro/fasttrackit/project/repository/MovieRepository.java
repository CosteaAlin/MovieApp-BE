package ro.fasttrackit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findAll();

    Optional<MovieEntity> findById(int id);
}
