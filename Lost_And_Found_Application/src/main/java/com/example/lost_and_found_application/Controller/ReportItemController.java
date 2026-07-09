package com.example.lost_and_found_application.Controller;

import com.example.lost_and_found_application.HelloApplication;
import com.example.lost_and_found_application.model.Item;
import com.example.lost_and_found_application.utility.ConnectionSingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReportItemController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private RadioButton foundRadio;

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField locationField;

    @FXML
    private RadioButton lostRadio;

    @FXML
    private ToggleGroup statusToggleGroup;

    @FXML
    private Button submitButton;

    @FXML
    private Button uploadImageButton;

    private String imagePath;

    public static Item itemToEdit;


    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> category = FXCollections.observableArrayList();
        category.addAll("Electronics", "Wallets & Purses", "Keys, Personal Documents", "Clothing & Accessories");
        categoryComboBox.setItems(category);

        if(itemToEdit != null){

            itemNameField.setText(itemToEdit.getItemName());
            categoryComboBox.setValue(itemToEdit.getCategory());
            locationField.setText(itemToEdit.getLocation());
            descriptionArea.setText(itemToEdit.getDescription());
            imagePath = itemToEdit.getImage();

            if(itemToEdit.getStatus() != null && itemToEdit.getStatus().equals("Found")){
                foundRadio.setSelected(true);
            }else{
                lostRadio.setSelected(true);
            }

            if(itemToEdit.getDate() != null && !itemToEdit.getDate().isEmpty()){
                try{
                    datePicker.setValue(LocalDate.parse(itemToEdit.getDate()));
                }catch(Exception e){

                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void handleCancel(ActionEvent event) throws IOException {

        itemToEdit = null;
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.changeScene("dashboard.fxml");
    }

    @FXML
    void handleSubmit(ActionEvent event) throws IOException, SQLException {

        if(categoryComboBox.getValue() != null && datePicker.getValue() != null && itemNameField.getText() != null && descriptionArea.getText() != null && locationField.getText() != null && (lostRadio.isSelected() || foundRadio.isSelected()) && imagePath != null) {

            Connection connection = ConnectionSingleton.getConnection();
            if(itemToEdit != null){

                String query = "update itemlist set name=?, category=?, status=?, location=?, date=?, description=?, image=? where name=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, itemNameField.getText());
                statement.setString(2, categoryComboBox.getValue());
                RadioButton radioButton = (RadioButton) statusToggleGroup.getSelectedToggle();
                statement.setString(3, radioButton.getText());
                statement.setString(4, locationField.getText());
                statement.setString(5, datePicker.getValue().toString());
                statement.setString(6, descriptionArea.getText());
                statement.setString(7, imagePath);
                statement.setString(8, itemToEdit.getItemName());
                statement.executeUpdate();

                itemToEdit = null;
            }else{

                connection = ConnectionSingleton.getConnection();
                String query = "insert into itemlist values(?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, itemNameField.getText());
                statement.setString(2, categoryComboBox.getValue());
                RadioButton radioButton = (RadioButton) statusToggleGroup.getSelectedToggle();
                statement.setString(3, radioButton.getText());
                statement.setString(4, locationField.getText());
                statement.setString(5, datePicker.getValue().toString());
                statement.setString(6, descriptionArea.getText());
                statement.setString(7, imagePath);
                statement.executeUpdate();

                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("dashboard.fxml");
            }
        }else{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please Fill Out every field");
            alert.showAndWait();
        }
    }

    @FXML
    void handleUploadImage(ActionEvent event) {

        FileChooser imageChooser = new FileChooser();
        File selectedFile = imageChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagePath = "file:///" + selectedFile.getPath().replace("\\", "/").replace(" ", "%20");
        }
    }

}
