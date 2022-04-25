package ro.fasttrackit.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.project.exceptions.ResourceNotFoundException;
import ro.fasttrackit.project.entity.MovieEntity;
import ro.fasttrackit.project.model.TMDBData;
import ro.fasttrackit.project.model.TMDBMovieDetails;
import ro.fasttrackit.project.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<TMDBMovieDetails> getMovies() {
        List<MovieEntity> movies = repository.findAll();
        return movies.stream()
                .map(this::getDataFromTMDB)
                .toList();
    }

    private TMDBMovieDetails getDataFromTMDB(MovieEntity movie) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.themoviedb.org/3/search/movie?api_key=2743738a13847a1180e24c4c1bad395b" +
                "&query=" + movie.getName() + "&include_adult=false";
        TMDBData tmdbData = restTemplate.getForObject(url, TMDBData.class);
        return getTMDBMovieDetails(movie, tmdbData);
    }

    private TMDBMovieDetails getTMDBMovieDetails(MovieEntity movie, TMDBData tmdbData) {
        Optional<TMDBData> result = Optional.ofNullable(tmdbData);
        if (result.isPresent()) {
            TMDBMovieDetails movieDetails = result.get().
                    getTmdbMovieDetails().
                    stream().
                    findFirst().
                    orElse(new TMDBMovieDetails());
            movieDetails.setMovieId(movie.getId());
            transformTMDBImageUrl(movieDetails);
            return movieDetails;
        } else {
            throw new ResourceNotFoundException("The movie does not exist on TMDB");
        }
    }

    private void transformTMDBImageUrl(TMDBMovieDetails movieDetails) {
        movieDetails.setImage("https://image.tmdb.org/t/p/original" + movieDetails.getImage());
    }
}
