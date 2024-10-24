package controller;


import Util.ServiceType;
import com.jfoenix.controls.JFXTextField;
import dto.Employee;
import javafx.collections.ObservableList;
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


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class admin_dashboardController implements Initializable {

    @FXML
    private TableView<Employee> tblEmployees;

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
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colsize;

    @FXML
    private TableColumn<?, ?> colsupplier;

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
    private JFXTextField txtinventoryname;

    @FXML
    private JFXTextField txtquantity;

    @FXML
    private JFXTextField txtsize;

    @FXML
    private JFXTextField txtsupplier;

    EmployeeService service = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);
    //dan balapan

    @FXML
    void btnemprefresh(ActionEvent event) {

    }

    @FXML
    void btninventoryadd(ActionEvent event) {

    }

    @FXML
    void btninventoryremove(ActionEvent event) {

    }

    @FXML
    void btninventoryupdate(ActionEvent event) {

    }

    @FXML
    void btninvrefresh(ActionEvent event) {

    }

    @FXML
    void btnremove(ActionEvent event) {

    }

    @FXML
    void btnupdate(ActionEvent event) {

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
//        colid.setText(service.generateId());
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

        if (service.addEmployee(employee)) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Updated Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Employee!").show();
        }
        loadTable();//
    }

    private void setTextToValues(Employee newValue) {
        txt_empid.setText(newValue.getId());
        txtempname.setText(newValue.getName());
        txtcompany.setText(newValue.getCompany());
        txtemail.setText(newValue.getEmail());
        txtcontact.setText(newValue.getContact());
    }

    private void setTextToEmpty() {
        txtempname.setText("");
        txtcompany.setText("");
        txtemail.setText("");
        txtcontact.setText("");
    }

    private void loadTable(){
        try{
            ObservableList<Employee> employeesList = service.getAll();
            tblEmployees.setItems(employeesList);
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

}
