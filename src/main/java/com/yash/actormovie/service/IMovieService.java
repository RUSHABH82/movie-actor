package com.yash.actormovie.service;

import com.yash.actormovie.domain.ResultStatusResponse;
import com.yash.actormovie.domain.movies.MovieRequest;
import com.yash.actormovie.entity.Movie;
import com.yash.actormovie.exception.ActorMoviePortalException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService {
    ResponseEntity<Movie> fetchMovieById(Long id) throws ActorMoviePortalException;

    ResponseEntity<List<Movie>> fetchAllMovies() throws ActorMoviePortalException;

    ResponseEntity<ResultStatusResponse> addMovie(MovieRequest movieRequest) throws ActorMoviePortalException;

    ResponseEntity<ResultStatusResponse> updateMovie(Long id, MovieRequest movieRequest) throws ActorMoviePortalException;

    ResponseEntity<ResultStatusResponse> deleteMovieById(Long id) throws ActorMoviePortalException;
}
