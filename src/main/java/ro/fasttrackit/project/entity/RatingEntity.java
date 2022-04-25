package ro.fasttrackit.project.entity;

import javax.persistence.*;

@Entity
public class RatingEntity {

    @Id
    @GeneratedValue
    private int id;
    private int movieRating;

    @OneToOne
    private MovieEntity movie;

    public RatingEntity() {
    }

    public RatingEntity(int rating) {
        this(rating, null);
    }

    public RatingEntity(int rating, MovieEntity movie) {
        this.movieRating = rating;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", movieRating=" + movieRating +
                ", movie=" + movie +
                '}';
    }
}
