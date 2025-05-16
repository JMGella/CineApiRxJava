package com.example.apicinemarxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Screening {

    private long id;
    private LocalDate screeningDate;
    private String theaterRoom;
    private double ticketPrice;
    private boolean subtitled;
    private long movie_id;

}
