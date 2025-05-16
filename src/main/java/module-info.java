module com.example.apicinemarxjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apicinemarxjava to javafx.fxml;
    exports com.example.apicinemarxjava;
    exports com.example.apicinemarxjava.controller;
    opens com.example.apicinemarxjava.controller to javafx.fxml;
}