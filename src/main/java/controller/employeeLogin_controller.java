package controller;

import Util.ServiceType;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.LoginService;

import java.io.IOException;

public class employeeLogin_controller {
    @FXML
    private AnchorPane scenepane;
    @FXML
    private JFXPasswordField txtemppassword;

    @FXML
    private JFXTextField txtempusername;

    LoginService loginService = ServiceFactory.getInstance().getServiceType(ServiceType.LOGIN);


    @FXML
    void btnLogin(ActionEvent event) {
        Stage stage = (Stage) scenepane.getScene().getWindow();
        boolean isValid =  verifyLogin(loginService.getLogin(txtempusername.getText()));

        if(isValid) {
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/employee_dashboard.fxml"))));
                stage.setTitle("Employee dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    private boolean verifyLogin(Login login) {
//        Login login1 = new Login(txtadminusername.getText(),txtadminpassword.getText());
        return (login.getEmail().equals(txtempusername.getText()))&&(login.getPassword().equals(txtemppassword.getText()));
    }

    @FXML
    void btnrecoverpassword(ActionEvent event) {

    }

    @FXML
    void btnemppasswordrecover(ActionEvent event) {

    }
    @FXML
     void btnback(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/home_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Home page");
        } catch (IOException e) {

        }

    }
}
