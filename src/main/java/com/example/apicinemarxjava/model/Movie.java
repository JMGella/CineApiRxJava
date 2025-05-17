package com.example.apicinemarxjava.model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Expose
    private long id;
    @Expose
    private String title;
    @Expose
    private String genre;
    @Expose
    private int durationMinutes;
    @Expose
    private String releaseDate;
    @Expose
    private boolean currentlyShowing;
    @Expose
    private List<Screening> screenings;
}
