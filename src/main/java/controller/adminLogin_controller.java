package controller;

import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class adminLogin_controller {
    @FXML
    private AnchorPane scenepane;
    @FXML
    private JFXPasswordField txtadminpassword;

    @FXML
    private JFXTextField txtadminusername;

    @FXML
    void btnLogin(ActionEvent actionEvent) {
        Stage stage = (Stage) scenepane.getScene().getWindow();

        try {
            stage.setScene( new Scene(FXMLLoader.load(getClass().getResource("../view/employee_dashboard.fxml"))));
            stage.setTitle("admin dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void btnrecoverpassword(ActionEvent event) {

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
