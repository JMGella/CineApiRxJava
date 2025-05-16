module com.example.apicinemarxjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3.logging;
    requires okhttp3;
    requires com.google.gson;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires rxjava3.retrofit.adapter;
    requires io.reactivex.rxjava3;
    requires static lombok;


    opens com.example.apicinemarxjava to javafx.fxml;
    exports com.example.apicinemarxjava;
    exports com.example.apicinemarxjava.controller;
    opens com.example.apicinemarxjava.controller to javafx.fxml;
}