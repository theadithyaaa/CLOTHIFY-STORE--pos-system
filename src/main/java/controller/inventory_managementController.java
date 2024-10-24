package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class inventory_managementController {

    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colsize;

    @FXML
    private TableColumn<?, ?> colsupplier;

    @FXML
    private JFXTextField txtcategory;

    @FXML
    private JFXTextField txtitemname;

    @FXML
    private JFXTextField txtquantity;

    @FXML
    private JFXTextField txtsize;

    @FXML
    private JFXTextField txtsupplier;

    @FXML
    void btnaddinventory(ActionEvent event) {

    }

    @FXML
    void btnrefresh(ActionEvent event) {

    }

    @FXML
    void btnremoveinventory(ActionEvent event) {

    }

    @FXML
    void btnupdateinventory(ActionEvent event) {

    }

    public void btnback(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employee_dashboard.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Employee Dashboard  ");
        } catch (IOException e) {

        }
    }
}
