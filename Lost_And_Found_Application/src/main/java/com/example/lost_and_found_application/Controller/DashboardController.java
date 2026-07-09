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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

        @FXML
        private TableColumn<Item, String> categoryColumn;

        @FXML
        private Button dashboardNavBtn;

        @FXML
        private TableColumn<Item, String> dateColumn;

        @FXML
        private Button deleteButton;

        @FXML
        private Button editButton;

        @FXML
        private Label foundCountLabel;

        @FXML
        private TableView<Item> itemsTable;

        @FXML
        private TableColumn<Item, String> locationColumn;

        @FXML
        private Button logoutButton;

        @FXML
        private Label lostCountLabel;

        @FXML
        private TableColumn<Item, String> nameColumn;

        @FXML
        private Button reportButton;

        @FXML
        private Button reportNavBtn;

        @FXML
        private Button searchButton;

        @FXML
        private TextField searchField;

        @FXML
        private Button settingsNavBtn;

        @FXML
        private TableColumn<Item, String> statusColumn;

        private ObservableList<Item> itemList = FXCollections.observableArrayList();

        @FXML
        void handleDelete(ActionEvent event) {

                Item selectedItem = itemsTable.getSelectionModel().getSelectedItem();

                if(selectedItem != null){
                        try{
                                Connection connection = ConnectionSingleton.getConnection();
                                String deleteQuery = "delete from itemlist where name=?";
                                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                                preparedStatement.setString(1, selectedItem.getItemName());
                                preparedStatement.executeUpdate();

                                itemList.remove(selectedItem);
                        }catch(SQLException e){

                                System.out.println("sql exception");
                                e.printStackTrace();
                        }
                }
                currentDashboard();
        }

        @FXML
        void handleEdit(ActionEvent event) throws IOException {

                Item selectedItem = itemsTable.getSelectionModel().getSelectedItem();

                if(selectedItem != null){

                        ReportItemController.itemToEdit = selectedItem;
                        HelloApplication helloApplication = new HelloApplication();
                        helloApplication.changeScene("reportItem.fxml");
                }else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("No item selected");
                        alert.setContentText("Please select an item");
                        alert.showAndWait();
                }
        }

        @FXML
        void handleLogout(ActionEvent event) throws IOException {

                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("Login.fxml");
        }

        @FXML
        void itemDetails(ActionEvent event) throws IOException {

                Item selectedItem = itemsTable.getSelectionModel().getSelectedItem();

                if(selectedItem != null){

                        ItemDetailsController.itemToShow = selectedItem;
                        HelloApplication helloApplication = new HelloApplication();
                        helloApplication.changeScene("itemDetails.fxml");
                }else{

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("No Item Selected");
                        alert.setContentText("Please select an item from the table first");
                        alert.showAndWait();
                }
        }

        @FXML
        void handleSearch(ActionEvent event) {

                if(itemsTable != null && searchField.getText() != null){

                        String keyword = searchField.getText();

                        if(keyword != null && !keyword.isEmpty()){

                                itemList.clear();
                                try{
                                        Connection connection = ConnectionSingleton.getConnection();
                                        String query = "select * from itemlist where name=? or category=? or status=? or location=?";
                                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                                        preparedStatement.setString(1, keyword);
                                        preparedStatement.setString(2, keyword);
                                        preparedStatement.setString(3, keyword);
                                        preparedStatement.setString(4, keyword);
                                        ResultSet searchResultSet = preparedStatement.executeQuery();
                                        while(searchResultSet.next()) {
                                                Item item = new Item();
                                                item.setItemName(searchResultSet.getString("name"));
                                                item.setCategory(searchResultSet.getString("category"));
                                                item.setStatus(searchResultSet.getString("status"));
                                                item.setDate(searchResultSet.getString("date"));
                                                item.setLocation(searchResultSet.getString("location"));
                                                item.setDescription(searchResultSet.getString("description"));
                                                item.setImage(searchResultSet.getString("image"));
                                                itemList.add(item);
                                        }
                                        itemsTable.setItems(itemList);
                                }catch(SQLException e){

                                        System.out.println("sql exception");
                                        e.printStackTrace();
                                }
                        }else{

                                loadTableData();
                        }
                }
        }

        @FXML
        void showDashboard(ActionEvent event) throws SQLException {

                loadTableData();
        }

        @FXML
        void showReportItem(ActionEvent event) throws IOException {

                ReportItemController.itemToEdit = null;
                HelloApplication helloApplication = new HelloApplication();
                helloApplication.changeScene("reportItem.fxml");
        }

        void loadTableData() {

                itemList.clear();
                try{
                        Connection connection = ConnectionSingleton.getConnection();
                        String itemQuery = "select * from itemlist";
                        PreparedStatement preparedStatement = connection.prepareStatement(itemQuery);
                        ResultSet itemResultSet = preparedStatement.executeQuery();
                        while(itemResultSet.next()) {
                                Item item = new Item();
                                item.setItemName(itemResultSet.getString("name"));
                                item.setCategory(itemResultSet.getString("category"));
                                item.setStatus(itemResultSet.getString("status"));
                                item.setDate(itemResultSet.getString("date"));
                                item.setLocation(itemResultSet.getString("location"));
                                item.setDescription(itemResultSet.getString("description"));
                                item.setImage(itemResultSet.getString("image"));
                                itemList.add(item);
                        }
                        itemsTable.setItems(itemList);
                }catch(SQLException e){

                        System.out.println("sql exception");
                        e.printStackTrace();
                }
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                currentDashboard();
                loadTableData();
        }

        public void currentDashboard(){

                int lostCount = 0;
                int foundCount = 0;
                try{
                        Connection connection = ConnectionSingleton.getConnection();
                        String foundQuery = "select count(*) from itemlist where status='Found'";
                        PreparedStatement preparedStatement = connection.prepareStatement(foundQuery);
                        ResultSet foundResultSet = preparedStatement.executeQuery();
                        while(foundResultSet.next()) {
                                foundCount = foundResultSet.getInt(1);
                        }
                        foundCountLabel.setText(Integer.toString(foundCount));
                }catch(SQLException e) {

                        System.out.println("sql exception");
                        e.printStackTrace();
                }
                try{
                        Connection connection = ConnectionSingleton.getConnection();
                        String lostQuery = "select count(*) from itemlist where status='Lost'";
                        PreparedStatement preparedStatement = connection.prepareStatement(lostQuery);
                        ResultSet lostResultSet = preparedStatement.executeQuery();
                        while(lostResultSet.next()) {
                                lostCount = lostResultSet.getInt(1);
                        }
                        lostCountLabel.setText(Integer.toString(lostCount));
                }catch(SQLException e){

                        System.out.println("sql exception");
                        e.printStackTrace();
                }
        }
}
