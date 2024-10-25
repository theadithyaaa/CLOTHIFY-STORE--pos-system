package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class create_accountController {

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXPasswordField txtpassword;

    @FXML
     void btnback(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/home_page.fxml"));
            currentStage.setScene(new Scene(loader.load()));
            currentStage.setTitle("Home page");
        } catch (IOException e) {

        }

    }

    @FXML
    void btncreateAccount(ActionEvent event) {
        Pattern ppassword= Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher mpassword = ppassword.matcher(txtpassword.getText());
        Pattern pemail= Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher memail = pemail.matcher(txtemail.getText());
        if(txtpassword.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Enter a password").show();
        } else if (txtemail.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Enter an email").show();
        } else if (!memail.matches()) {
            new Alert(Alert.AlertType.ERROR,"Invalid Email format").show();
        } else if (!mpassword.matches()) {
            new Alert(Alert.AlertType.ERROR,"To weak").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Registered Successfully").show();
        }

        Login login = new Login(
                txtpassword.getText(),
                txtemail.getText()
        );
        

    }


}
