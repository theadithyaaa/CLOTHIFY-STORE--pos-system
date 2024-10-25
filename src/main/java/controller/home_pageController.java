package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.IOException;

public class home_pageController {

    @FXML
    public void btnAdmin(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/adminLogin_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Admin Login");
        } catch (IOException e) {

        }
    }




    @FXML
    void btnEmployee(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employeeLogin_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Employee Login");
        } catch (IOException e) {

        }
    }

    public void btnCreate(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/create_account.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle(" create account");
        } catch (IOException e) {

        }

    }
}

