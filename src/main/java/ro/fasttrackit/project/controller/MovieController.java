package ro.fasttrackit.project.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.project.dto.MovieDTO;
import ro.fasttrackit.project.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieService service;
    private final ModelMapper modelMapper;

    public MovieController(MovieService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    List<MovieDTO> getMovies() {
        return service.getMovies().stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .toList();
    }
}
