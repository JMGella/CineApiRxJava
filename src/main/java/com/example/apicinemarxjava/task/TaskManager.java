package com.example.apicinemarxjava.task;

import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.service.ApiService;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;



public class TaskManager extends Task<Integer> {

    private ObservableList<Movie> movieList;

    public TaskManager(ObservableList<Movie> movieList) {
        this.movieList = movieList;
    }


    @Override
    protected Integer call() throws Exception {
        System.out.println("ejecutando task");
        ApiService apiService = new ApiService();
        Consumer<Movie> consumer = movie -> {
            Thread.sleep(200);
            System.out.println(movie.getTitle());
            Platform.runLater(() -> movieList.add(movie));

        };

        apiService.getAllMovies().subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(consumer);



        return 0;
    }
}
