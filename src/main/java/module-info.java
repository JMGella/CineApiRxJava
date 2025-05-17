module com.example.apicinemarxjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires static lombok;
    requires okhttp3.logging;
    requires okhttp3;
    requires rxjava3.retrofit.adapter;
    requires io.reactivex.rxjava3;



    opens com.example.apicinemarxjava to javafx.fxml;
    exports com.example.apicinemarxjava;
    exports com.example.apicinemarxjava.controller;
    opens com.example.apicinemarxjava.controller to javafx.fxml;
    opens com.example.apicinemarxjava.model to com.google.gson;

}