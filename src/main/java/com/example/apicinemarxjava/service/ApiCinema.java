package com.example.apicinemarxjava.service;

import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.model.Screening;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import java.util.List;

public interface ApiCinema {

    @GET("movies")
    Observable<List<Movie>> getAllMovies();

    @GET("screenings")
    Observable<List<Screening>> getAllScreenings();

}

