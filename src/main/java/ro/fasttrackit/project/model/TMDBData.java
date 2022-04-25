package ro.fasttrackit.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TMDBData {

    @JsonProperty("results")
    private List<TMDBMovieDetails> tmdbMovieDetails;

    public List<TMDBMovieDetails> getTmdbMovieDetails() {
        return tmdbMovieDetails;
    }

    public void setTMDBMovieDetails(List<TMDBMovieDetails> tmdbMovieDetails) {
        this.tmdbMovieDetails = tmdbMovieDetails;
    }

    @Override
    public String toString() {
        return "Result{" +
                "tmdbMovieDetails=" + tmdbMovieDetails +
                '}';
    }
}
