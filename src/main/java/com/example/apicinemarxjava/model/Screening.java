package com.example.apicinemarxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Screening {

    long id;
    LocalDate screeningDate;
    String theaterRoom;
    double ticketPrice;
    boolean subtitled;
    long movie_id;

}
