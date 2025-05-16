package com.example.apicinemarxjava.service;


import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.model.Screening;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

 private String BASE_URL = "http://localhost:8080/";
 private ApiCinema apiCinema;

 public ApiService() {
     HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
     logging.setLevel(HttpLoggingInterceptor.Level.BODY);
     OkHttpClient client = new OkHttpClient.Builder()
             .addInterceptor(logging)
             .build();

     Gson gson = new GsonBuilder()
             .setLenient()
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

     return apiCinema.getAllMovies()
             .flatMapIterable(movie -> movie);
 }

 public Observable<Screening> getAllScreenings() {
     return apiCinema.getAllScreenings()
             .flatMapIterable(screening -> screening);
 }




}
