module com.example.devoir {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;



    opens com.example.devoir to javafx.fxml;
    exports com.example.devoir;
}