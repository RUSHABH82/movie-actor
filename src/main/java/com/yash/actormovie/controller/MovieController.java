package com.yash.actormovie.controller;

import com.yash.actormovie.domain.ResultStatusResponse;
import com.yash.actormovie.domain.movies.MovieRequest;
import com.yash.actormovie.entity.Movie;
import com.yash.actormovie.exception.ActorMoviePortalException;
import com.yash.actormovie.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    public ResponseEntity<Movie> fetchMovieById(Long id) throws ActorMoviePortalException {
        return null;
    }


    @GetMapping("")
    public ResponseEntity<List<Movie>> fetchAllMovies() throws ActorMoviePortalException {
        return movieService.fetchAllMovies();
    }

    public ResponseEntity<ResultStatusResponse> addMovie(MovieRequest movieRequest) throws ActorMoviePortalException {
        return null;
    }

    public ResponseEntity<ResultStatusResponse> updateMovie(Long id, MovieRequest movieRequest) throws ActorMoviePortalException {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResultStatusResponse> deleteMovieById(@PathVariable Long id) throws ActorMoviePortalException {


        return movieService.deleteMovieById(id);
    }
}
