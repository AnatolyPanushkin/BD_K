package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import OpenWindow.OpenWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.DatabaseHandler;
import sample.User;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttomAdd;

    @FXML
    private Button buttomExit;

    @FXML
    private TextField feildLogin;

    @FXML
    private TextField feildPassword;

    @FXML
    private TextField feildStatus;

    @FXML
    private TextField deleteLogin;

    @FXML
    private TextField deletePassword;

    @FXML
    private TextField deleteStatus;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button listUser;

    @FXML
    void initialize() {

        listUser.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Admin/UserTable.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        buttomAdd.setOnAction(event->{
            signUpNewUser();
            feildLogin.clear();
            feildPassword.clear();
            feildStatus.clear();
        });
        buttonDelete.setOnAction(event ->{
            deleteUser();
            deleteLogin.clear();
            deletePassword.clear();
            deleteStatus.clear();
        });
        buttomExit.setOnAction(event->{
            OpenWindow window = new OpenWindow();
            window.openWindow(buttomAdd,"/sample/sample.fxml");
        });
    }
    private void  signUpNewUser(){
        DatabaseHandler dbHandler=new DatabaseHandler();
        String login =feildLogin.getText();
        String password=feildPassword.getText();
        String status=feildStatus.getText();

        User user =new User(login,password,status);

        dbHandler.signUpUser(user);
    }
    private void deleteUser(){
        DatabaseHandler dbHandler=new DatabaseHandler();
        String login =deleteLogin.getText();
        String password=deletePassword.getText();
        String status=deleteStatus.getText();

        User user =new User(login,password,status);

        dbHandler.deleteUser(user);
    }
}