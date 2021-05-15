package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import OpenWindow.OpenWindow;
import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttomEnter;

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private TextField userStatus;

    @FXML
    void initialize() {
       buttomEnter.setOnAction(event -> {
           String loginText= fieldLogin.getText().trim();
           String passwordText=fieldPassword.getText().trim();
           String status = userStatus.getText().trim();

           if(!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText,passwordText,status);
           }
           else
               System.out.println("Login or password is empty");

       });

    }

    private void loginUser(String loginText, String passwordText,String status) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user=new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        user.setStatus(status);
        ResultSet result = dbHandler.getUser(user);

        int counter =0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1 && user.getStatus().equals("admin")){
            OpenWindow window = new OpenWindow();
            window.openWindow(buttomEnter,"/Admin/AdminController.fxml");
            System.out.println("S");
        }
        if(counter>=1 && user.getStatus().equals("user")){
            OpenWindow window = new OpenWindow();
            window.openWindow(buttomEnter,"/User/UserController.fxml");
            System.out.println("S");
        }
        if(counter>=1 && user.getStatus().equals("operator")){
            OpenWindow window = new OpenWindow();
            window.openWindow(buttomEnter,"/Operator/OperatorController.fxml");
            System.out.println("S");
        }
    }



}