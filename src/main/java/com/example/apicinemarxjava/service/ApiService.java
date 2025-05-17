package com.example.apicinemarxjava.service;


import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.model.Screening;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;


import io.reactivex.rxjava3.core.Observable;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


public class ApiService {

 private String BASE_URL = "http://127.0.0.1:8080/";
 private ApiCinema apiCinema;

 public ApiService() throws IOException {
     HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
     logging.setLevel(HttpLoggingInterceptor.Level.BODY);
     OkHttpClient client = new OkHttpClient.Builder()
             .addInterceptor(logging)
             .build();


     Gson gson = new GsonBuilder()
             .excludeFieldsWithoutExposeAnnotation() // Opcional si usas @Expose
             .serializeNulls()
             .disableHtmlEscaping()
             .setLenient()
             .enableComplexMapKeySerialization()
             .setPrettyPrinting()
             .create();

     Retrofit retrofit = new Retrofit.Builder()
             .baseUrl(BASE_URL)
             .client(client)
             .addConverterFactory(GsonConverterFactory.create(gson))
             .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
             .build();



     this.apiCinema = retrofit.create(ApiCinema.class);



 }

    public Observable<Movie> getAllMovies() {
        System.out.println("ejecutando apiservice getAllMovies");
        return apiCinema.getAllMovies()
                .flatMapIterable(movies -> movies);
    }


 public Observable<Screening> getAllScreenings() {
     return apiCinema.getAllScreenings()
             .flatMapIterable(screening -> screening);
 }




}
