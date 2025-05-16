package com.example.apicinemarxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private long id;
    private String title;
    private String genre;
    private int durationMinutes;
    private LocalDate releaseDate;
    private boolean currentlyShowing;
}
