package com.example.apicinemarxjava.task;

import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.service.ApiService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import io.reactivex.rxjava3.functions.Consumer;

public class TaskManager extends Task<Integer> {

    private ObservableList<Movie> movieList;

    public TaskManager(ObservableList<Movie> movieList) {
        this.movieList = movieList;
    }


    @Override
    protected Integer call() throws Exception {
        ApiService apiService = new ApiService();
        Consumer<Movie> consumer = movie -> {
            Thread.sleep(200);
            Platform.runLater(() -> movieList.add(movie));
        };

        apiService.getAllMovies().subscribe(consumer);

        return 0;
    }
}
