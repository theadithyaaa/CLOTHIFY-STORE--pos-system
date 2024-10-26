package controller;

import Util.ServiceType;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.Orders;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.OrderService;
import service.custom.SupplierService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class orders_managementController implements Initializable {
    @FXML
    public TableColumn colitemname;
    @FXML
    public JFXTextField txtitemname;
    public TableView <Orders> tblOrders;
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
    OrderService orderService = ServiceFactory.getInstance().getServiceType(ServiceType.ORDER);


    @FXML
    void btnorder(ActionEvent event) {

        Orders orders = new Orders(
                txtcusid.getText(),
                txtitemcode.getText(),
                txtquantity.getText(),
                txtprice.getText(),
                txtname.getText(),
                txttotal.getText()
        );
        if (orderService.addOrders(orders)) {
            new Alert(Alert.AlertType.INFORMATION, "order Added Successfully!").show();
            setTextToEmpty();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Added order!").show();
        }
        loadTable();

    }

    private void setTextToEmpty() {
        txttotal.setText("");
        txtitemname.setText("");
        txtquantity.setText("");
        txtprice.setText("");
        txtcusid.setText("");
        txtcusname.setText("");
        txtname.setText("");

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colcode.setCellValueFactory(new PropertyValueFactory<>("name"));
        colitemname.setCellValueFactory(new PropertyValueFactory<>("company"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("email"));
        colquantiy.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblOrders.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) ->
        {
            if (null != newValue) {
                setTextToValues(newValue);
            }
            loadTable();
        }));

    }

    private void setTextToValues(Orders newValue) {
        txtitemname.setText(newValue.getId());
        txtitemcode.setText(newValue.getName());
        txtprice.setText(newValue.getPrice());
        txtquantity.setText(newValue.getQuantity());
        txttotal.setText(newValue.getTotal());
    }
    private void loadTable(){
        try{
            tblOrders.setItems(FXCollections.observableArrayList(orderService.getAll()));
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
