package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class employeeLogin_controller {

    @FXML
    private JFXPasswordField txtemppassword;

    @FXML
    private JFXTextField txtempusername;

    @FXML
    void btnLogin(ActionEvent event) {

    }

    @FXML
    void btnemppasswordrecover(ActionEvent event) {

    }

    public void btnback(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/home_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Home page");
        } catch (IOException e) {

        }
    }
}
