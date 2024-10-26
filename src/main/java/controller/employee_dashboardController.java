package controller;

import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class employee_dashboardController {

    @FXML
    private Label txtcompany;

    @FXML
    private JFXPasswordField txtconfirmnewpassword;

    @FXML
    private JFXPasswordField txtnewpassword;

    @FXML
    private Label txtuseremail;

    @FXML
    private Label txtuserid;

    @FXML
    private Label txtusername;

    @FXML
    void btnchangepassword(ActionEvent event) {

    }

    @FXML
    void btninventory(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/inventory_management.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Inventory Management ");
        } catch (IOException e) {

        }
    }

    @FXML
    void btnorders(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/orders_management.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Orders Management ");
        } catch (IOException e) {

        }

    }

    @FXML
    void btnsuppliers(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/supplier_management.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Supllier Management ");
        } catch (IOException e) {

        }

    }

    public void btnback(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employeeLogin_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Employee login");
        } catch (IOException e) {

        }
    }
}
