package User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import OpenWindow.OpenWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttomExit;

    @FXML
    private Button buttonView;

    @FXML
    void initialize() {
        buttomExit.setOnAction(event -> {
            OpenWindow window = new OpenWindow();
            window.openWindow(buttomExit,"/sample/sample.fxml");
        });
        buttonView.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/User/ViewTable.fxml"));

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

    }
}
