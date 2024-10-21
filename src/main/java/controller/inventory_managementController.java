package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

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

}
