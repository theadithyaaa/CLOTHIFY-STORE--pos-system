package controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class orders_managementController {

    @FXML
    private JFXRadioButton btncard;

    @FXML
    private JFXRadioButton btncash;

    @FXML
    private TableColumn<?, ?> colcode;

    @FXML
    private TableColumn<?, ?> colcus;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colpayment;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private TableColumn<?, ?> colquantiy;

    @FXML
    private TableColumn<?, ?> coltotal;

    @FXML
    private JFXTextField txtcusid;

    @FXML
    private JFXTextField txtcusname;

    @FXML
    private JFXTextField txtitemcode;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtprice;

    @FXML
    private JFXTextField txtquantity;

    @FXML
    private Label txttotal;

    @FXML
    void btnorder(ActionEvent event) {

    }

    @FXML
    void btnrefresh(ActionEvent event) {

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
