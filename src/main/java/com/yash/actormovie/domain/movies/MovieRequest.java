package com.yash.actormovie.domain.movies;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieRequest {

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String genre;

}
