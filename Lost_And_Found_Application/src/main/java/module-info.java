module com.example.lost_and_found_application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lost_and_found_application to javafx.fxml;
    opens com.example.lost_and_found_application.Controller to javafx.fxml;
    exports com.example.lost_and_found_application;
    exports com.example.lost_and_found_application.model;
    opens com.example.lost_and_found_application.model to javafx.fxml;
}