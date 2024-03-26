package com.yash.actormovie.service;

import com.yash.actormovie.domain.ResultStatus;
import com.yash.actormovie.domain.ResultStatusResponse;
import com.yash.actormovie.domain.movies.MovieRequest;
import com.yash.actormovie.entity.Movie;
import com.yash.actormovie.exception.ActorMoviePortalException;
import com.yash.actormovie.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
import java.util.List;

import static com.yash.actormovie.constant.ActorMovieConst.*;


@Service
public class MovieService implements IMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
    private static final String MET_FETCH_MOVIE_BY_ID = "fetchMovieById";


    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public ResponseEntity<Movie> fetchMovieById(Long id) throws ActorMoviePortalException {
        try {
            return new ResponseEntity<>(getById(id), HttpStatus.OK);
        } catch (ActorMoviePortalException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error(CLS_MET_ERROR, this.getClass(), MET_FETCH_MOVIE_BY_ID, e.getMessage());
            throw new ActorMoviePortalException("Unable to fetch move, Try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Movie>> fetchAllMovies() throws ActorMoviePortalException {
        try {
            return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(CLS_MET_ERROR, this.getClass(), MET_FETCH_MOVIE_BY_ID, e.getMessage());
            throw new ActorMoviePortalException("Unable to fetch move, Try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResultStatusResponse> addMovie(MovieRequest movieRequest) throws ActorMoviePortalException {
        return null;
    }

    @Override
    public ResponseEntity<ResultStatusResponse> updateMovie(Long id, MovieRequest movieRequest) throws ActorMoviePortalException {
        return null;
    }

    @Override
    public ResponseEntity<ResultStatusResponse> deleteMovieById(Long id) throws ActorMoviePortalException {

        getById(76L);

        return new ResponseEntity<>(genereteSuccessMessgae(), HttpStatus.OK);
    }


    private Movie getById(Long id) throws ActorMoviePortalException {
        return movieRepository.findById(id).orElseThrow(() ->
                new ActorMoviePortalException("Movie not found by given id!", HttpStatus.BAD_REQUEST)
        );
    }


    private ResultStatusResponse genereteSuccessMessgae() {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setStatus("SUCCESS");
        return new ResultStatusResponse(resultStatus);
    }

}
