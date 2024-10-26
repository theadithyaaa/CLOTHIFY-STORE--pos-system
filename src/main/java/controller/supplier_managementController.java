package controller;

import Util.ServiceType;
import com.jfoenix.controls.JFXTextField;
import dto.Employee;
import dto.Supplier;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import service.custom.SupplierService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class supplier_managementController implements Initializable {
    @FXML
    private JFXTextField txtid;
    @FXML
    private TableView <Supplier> tblsupplier;
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
    SupplierService supplierService = ServiceFactory.getInstance().getServiceType(ServiceType.SUPPLIER);

    @FXML
    void btnaddsupplier(ActionEvent event) {
        Supplier supplier = new Supplier(
          txtid.getText(),
          txtsuppliername.getText(),
          txtcompnay.getText(),
          txtemail.getText()
        );
        if (supplierService.addSupplier(supplier)) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Added Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Added Employee!").show();
        }
        loadTable();


    }

    private void setTextToEmpty() {
        txtcompnay.setText("");
        txtid.setText("");
        txtsuppliername.setText("");
        txtemail.setText("");

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblsupplier.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            if (null != newValue) {
                setTextToValue((Supplier)newValue);
            }
        }));
        loadTable();
    }

    private void setTextToValue(Supplier newValue) {
        txtid.setText(newValue.getId());
        txtsuppliername.setText(newValue.getName());
        txtcompnay.setText(newValue.getCompany());
        txtemail.setText(newValue.getEmail());
    }


    @FXML
    void btnremovesupplier(ActionEvent event) {
        supplierService.deleteSupplier(txtid.getText());
        loadTable();
        setTextToEmpty();

    }

    @FXML
    void btnupdtesupplier(ActionEvent event) {
        Supplier supplier = new Supplier(
                txtid.getText(),
                txtsuppliername.getText(),
                txtcompnay.getText(),
                txtemail.getText()

        );
        supplierService.updateSupplier(supplier);
        loadTable();
        setTextToEmpty();

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



    private void loadTable(){
        try{
            tblsupplier.setItems(FXCollections.observableArrayList(supplierService.getAll()));
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
