package com.example.apicinemarxjava.service;

import com.example.apicinemarxjava.model.Pelicula;
import com.example.apicinemarxjava.model.Proyeccion;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface ApiCinema {

    @GET("peliculas/")
    Observable<List<Pelicula>> getAllPeliculas();

    @GET("proyecciones/")
    Observable<List<Proyeccion>> getAllProyecciones();

}
