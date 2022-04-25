package ro.fasttrackit.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TMDBMovieDetails {

    private int movieId;

    @JsonProperty("original_title")
    private String title;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster_path")
    private String image;

    @JsonProperty("release_date")
    private String releaseDate;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TMDBMovieDetails{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", image='" + image + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}