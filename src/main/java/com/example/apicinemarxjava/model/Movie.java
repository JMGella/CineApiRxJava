package com.example.apicinemarxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class Movie {

    long id;
    String title;
    String genre;
    int durationMinutes;
    LocalDate releaseDate;
    boolean currentlyShowing;
}
