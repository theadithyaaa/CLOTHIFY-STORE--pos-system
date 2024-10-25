package controller;

import Util.ServiceType;
import com.jfoenix.controls.JFXTextField;
import dto.Inventory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.InventoryService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class inventory_managementController {

    public JFXTextField txtid;
    public TableView<Inventory> tblInventory;
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

    InventoryService inventoryservice = ServiceFactory.getInstance().getServiceType(ServiceType.INVENTORY);


    @FXML
    void btnaddinventory(ActionEvent event) {
        Inventory inventory = new Inventory(
                txtid.getText(),
                txtcategory.getText(),
                txtsize.getText(),
                txtquantity.getText(),
                txtitemname.getText()
        );

        if (inventoryservice.addInventory(inventory)) {
            new Alert(Alert.AlertType.INFORMATION, "Product Added Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Product!").show();
        }
        loadTable();

    }

    private void setTextToEmpty() {
        txtsize.setText("");
        txtquantity.setText("");
        txtitemname.setText("");
        txtid.setText("");
        txtcategory.setText("");
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
    private void loadTable(){
        try{
            tblInventory.setItems(FXCollections.observableArrayList(inventoryservice.getAll()));
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colsize.setCellValueFactory(new PropertyValueFactory<>("size"));
        tblInventory.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            if (null != newValue) {
                setTextToValues((Inventory) newValue);
            }
        }));

        loadTable();
    }

    private void setTextToValues(Inventory newValue) {
        txtid.setText(newValue.getId());
        txtitemname.setText(newValue.getName());
        txtcategory.setText(newValue.getCategory());
        txtquantity.setText(newValue.getQuantity());
        txtsize.setText(newValue.getSize());
    }
}
