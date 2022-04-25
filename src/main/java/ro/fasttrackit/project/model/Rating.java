package ro.fasttrackit.project.model;

public class Rating {
    private int id;
    private int movieRating;
    private int movieId;

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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "AddRating{" +
                "id=" + id +
                ", rating=" + movieRating +
                ", movieId=" + movieId +
                '}';
    }
}
