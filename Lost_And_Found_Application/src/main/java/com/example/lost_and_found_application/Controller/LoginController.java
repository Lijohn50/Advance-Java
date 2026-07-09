package com.example.lost_and_found_application.Controller;

import com.example.lost_and_found_application.HelloApplication;
import com.example.lost_and_found_application.utility.ConnectionSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Label forgotPassword;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void handleForgotPassword(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forgot Password");
        alert.setHeaderText("Forgot Password");
        alert.setContentText("Verification code has been sent to your email");
        alert.showAndWait();
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException, SQLException {

        Connection connection = ConnectionSingleton.getConnection();
        String query = "select * from userinfo";
        ResultSet result = connection.createStatement().executeQuery(query);
        while (result.next()){

            if(usernameField.getText().equals(result.getString("username")) && passwordField.getText().equals(result.getString("password"))){

                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("dashboard.fxml");
            }else{

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Login Error");
                alert.setHeaderText("Login Error");
                alert.setContentText("Invalid credentials or empty field");
                alert.showAndWait();
            }
        }
    }

}
