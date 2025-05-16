package com.example.apicinemarxjava.controller;

import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.task.TaskManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class AppController {

    private ObservableList<Movie> movieList;
    @FXML
    private TableView<Movie> tbMovies;
    @FXML
    private TableColumn<Movie, String> titleColumn;
    @FXML
    private TableColumn<Movie, String> genreColumn;
    @FXML
    private TableColumn<Movie, Integer> durationColumn;
    @FXML
    private TableColumn<Movie, LocalDate> releaseDateColumn;
    @FXML
    private TableColumn<Movie, Boolean> subtitledColumn;


    @FXML
    protected void getAllMovies(){
        TaskManager task = new TaskManager(movieList);


    }

    private void initialize() {

    }


}