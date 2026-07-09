package com.example.lost_and_found_application.Controller;

import com.example.lost_and_found_application.HelloApplication;
import com.example.lost_and_found_application.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemDetailsController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Label categoryLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button editButton;

    @FXML
    private ImageView itemImageView;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Button markReturnedButton;

    @FXML
    private Label reportedDateLabel;

    @FXML
    private Label statusBadge;

    public static Item itemToShow;

    @FXML
    void handleBack(ActionEvent event) throws IOException {

        itemToShow = null;
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("dashboard.fxml");
    }

    @FXML
    void handleEdit(ActionEvent event) throws IOException {

        if(itemToShow != null){

            ReportItemController.itemToEdit = itemToShow;
            itemToShow = null;
            HelloApplication helloApplication = new HelloApplication();
            helloApplication.changeScene("reportItem.fxml");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(itemToShow != null){

            itemNameLabel.setText(itemToShow.getItemName());
            statusBadge.setText(itemToShow.getStatus());
            categoryLabel.setText(itemToShow.getCategory());
            locationLabel.setText(itemToShow.getLocation());
            reportedDateLabel.setText(itemToShow.getDate());
            descriptionLabel.setText(itemToShow.getDescription());

            if(itemToShow.getImage() != null && !itemToShow.getImage().isEmpty()){

                try{
                    Image image = new Image(itemToShow.getImage());
                    itemImageView.setImage(image);
                }catch(Exception e){

                    e.printStackTrace();
                }
            }
        }
    }
}
