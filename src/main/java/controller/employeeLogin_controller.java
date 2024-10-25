package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class employeeLogin_controller {

    public AnchorPane scenepane;
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
        Stage stage = (Stage) scenepane.getScene().getWindow();

        try {
            stage.setScene( new Scene(FXMLLoader.load(getClass().getResource("../view/employee_dashboard.fxml"))));
            stage.setTitle("employee dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
