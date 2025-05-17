package com.example.apicinemarxjava.controller;

import com.example.apicinemarxjava.model.Movie;
import com.example.apicinemarxjava.task.TaskManager;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
    private TableColumn<Movie, String> releaseDateColumn;
    @FXML
    private TableColumn<Movie, Boolean> isShowingColumn;


    @FXML
    public void initialize() {
        movieList = FXCollections.observableArrayList();
        tbMovies.setItems(movieList);

        titleColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
        genreColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getGenre()));
        durationColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getDurationMinutes()).asObject());
        releaseDateColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getReleaseDate()));
        isShowingColumn.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().isCurrentlyShowing()));


    }

    @FXML
    protected void getAllMovies(){
        try {
            TaskManager task = new TaskManager(movieList);
            task.setOnFailed(onFailed -> {task.getException().printStackTrace();});
            new Thread(task).start();
            System.out.println("Task started");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}