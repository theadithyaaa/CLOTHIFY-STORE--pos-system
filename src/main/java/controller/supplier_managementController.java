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

public class supplier_managementController {

    @FXML
    private TableColumn<?, ?> colcompany;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colitem;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private JFXTextField txtcompnay;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtitmcode;

    @FXML
    private JFXTextField txtsuppliername;

    @FXML
    void btnaddsupplier(ActionEvent event) {

    }

    @FXML
    void btnrefresh(ActionEvent event) {

    }

    @FXML
    void btnremovesupplier(ActionEvent event) {

    }

    @FXML
    void btnupdtesupplier(ActionEvent event) {

    }

    public void btnback(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employee_dashboard.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Employee Dashboard  ");
        } catch (IOException e) {

        }
    }
}
