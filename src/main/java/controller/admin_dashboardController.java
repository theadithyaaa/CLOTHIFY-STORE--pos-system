package controller;


import Util.ServiceType;
import com.jfoenix.controls.JFXTextField;
import dto.Employee;
import dto.Inventory;
import dto.Login;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.EmployeeService;
import service.custom.InventoryService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class admin_dashboardController implements Initializable {
    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> colcompany;

    @FXML
    private TableColumn<?, ?> colcontact;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colitemid;

    @FXML
    private TableColumn<?, ?> colitemname;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colsize;

    @FXML
    private TableColumn<?, ?> colsupplier;

    @FXML
    private AnchorPane scenepane;

    @FXML
    private TableView<Employee> tblEmployees;

    @FXML
    private TableView<Inventory> tblInventory;

    @FXML
    private JFXTextField txt_empid;

    @FXML
    private JFXTextField txtcategory;

    @FXML
    private JFXTextField txtcompany;

    @FXML
    private JFXTextField txtcontact;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtempname;

    @FXML
    private JFXTextField txtinventoryid;

    @FXML
    private JFXTextField txtinventoryname;

    @FXML
    private JFXTextField txtquantity;

    @FXML
    private JFXTextField txtsize;

    EmployeeService employeeservice = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);
    InventoryService inventoryservice = ServiceFactory.getInstance().getServiceType(ServiceType.INVENTORY);


    @FXML
    void btnemprefresh(ActionEvent event) {

    }

    @FXML
    void btninventoryadd(ActionEvent event) {

        Inventory inventory = new Inventory(
                txtinventoryid.getText(),
                txtcategory.getText(),
                txtsize.getText(),
                txtquantity.getText(),
                txtinventoryname.getText()
        );

        if (inventoryservice.addInventory(inventory)) {
            new Alert(Alert.AlertType.INFORMATION, "Product Added Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Product!").show();
        }
        loadTable();

    }

    @FXML
    void btninventoryremove(ActionEvent event) {
        inventoryservice.deleteInventory(txtinventoryid.getText());
        loadTable();
        setTextToEmpty();

    }

    @FXML
    void btninventoryupdate(ActionEvent event) {
        Inventory inventory = new Inventory(
                txtinventoryid.getText(),
                txtinventoryname.getText(),
                txtcategory.getText(),
                txtsize.getText(),
                txtquantity.getText()
        );
        inventoryservice.updateInventory(inventory);
        loadTable();
        setTextToEmpty();

    }

    @FXML
    void btninvrefresh(ActionEvent event) {

    }

    @FXML
    void btnremove(ActionEvent event) {
        employeeservice.deleteEmployee(txt_empid.getText());
        loadTable();
        setTextToEmpty();
    }

    @FXML
    void btnupdate(ActionEvent event) {
        Employee employee = new Employee(
                txt_empid.getText(),
                txtempname.getText(),
                txtemail.getText(),
                txtcontact.getText(),
                txtcompany.getText()
        );
        employeeservice.updateEmployee(employee);
        loadTable();
        setTextToEmpty();
    }

    public void btnback(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/adminLogin_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Admin Login");
        } catch (IOException e) {

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblEmployees.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            if (null != newValue) {
                setTextToValues(newValue);
            }
        }));

        colitemid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colitemname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colsize.setCellValueFactory(new PropertyValueFactory<>("size"));
        tblInventory.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            if (null != newValue) {
                setTextToValues2((Inventory) newValue);
            }
        }));

        loadTable();
    }

    public void btnregister(ActionEvent actionEvent) {
        Employee employee = new Employee(
                txt_empid.getText(),
                txtempname.getText(),
                txtemail.getText(),
                txtcontact.getText(),
                txtcompany.getText()
        );

        if (employeeservice.addEmployee(employee)) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Added Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Added Employee!").show();
        }
        loadTable();
    }

    private void setTextToValues(Employee newValue) {
        txt_empid.setText(newValue.getId());
        txtempname.setText(newValue.getName());
        txtcompany.setText(newValue.getCompany());
        txtemail.setText(newValue.getEmail());
        txtcontact.setText(newValue.getContact());
    }

    private void setTextToEmpty() {
        txt_empid.setText("");
        txtempname.setText("");
        txtcompany.setText("");
        txtemail.setText("");
        txtcontact.setText("");
        txtsize.setText("");
        txtquantity.setText("");
        txtinventoryname.setText("");
        txtinventoryid.setText("");
        txtcategory.setText("");
    }

    private void loadTable(){
        try{
            tblEmployees.setItems(FXCollections.observableArrayList(employeeservice.getAll()));
            tblInventory.setItems(FXCollections.observableArrayList(inventoryservice.getAll()));
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setTextToValues2(Inventory newValue) {
        txtinventoryid.setText(newValue.getId());
        txtinventoryname.setText(newValue.getName());
        txtcategory.setText(newValue.getCategory());
        txtquantity.setText(newValue.getQuantity());
        txtsize.setText(newValue.getSize());
    }

}

