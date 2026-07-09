package com.example.lost_and_found_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setTitle("Lost and Found Application");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxmlName) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}

// create database lostfound;
// create table userinfo(username varchar(50), password varchar(50));
// insert into userinfo values(lijon, 1234);
// create table itemlist(name varchar(50), category varchar(50), status varchar(50), location varchar(50), date varchar(50), description varchar(100), image varchar(500));