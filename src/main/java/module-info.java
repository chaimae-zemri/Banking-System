module com.example.devoir {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    opens com.example.devoir to com.fasterxml.jackson.databind;


    exports com.example.devoir;
}