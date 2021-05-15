package Operator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.*;

public class OperatorController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField fieldTypeOfCar;

    @FXML
    private TextField Driver;

    @FXML
    private TextField fieldNumberOfStorage;

    @FXML
    private Button buttonExit;

    @FXML
    private Button listCar;

    @FXML
    private TextField deleteType;

    @FXML
    private TextField deleteNumber;

    @FXML
    private TextField deleteDriver;

    @FXML
    private TextField deleteStorage;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField fieldNumber;

    @FXML
    private Button addView;


    @FXML
    void initialize() {
        buttonAdd.setOnAction(event ->{
            addNewCar();

        });
        buttonExit.setOnAction(event ->{
            OpenWindow window = new OpenWindow();
            window.openWindow(buttonExit,"/sample/sample.fxml");
        });
        listCar.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Operator/CarTable.fxml"));

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
        buttonDelete.setOnAction(event ->{
            deleteCar();
            deleteType.clear();
            deleteNumber.clear();
            deleteDriver.clear();
            deleteStorage.clear();
        });
        addView.setOnAction(event ->{
            addView();
            fieldTypeOfCar.clear();
            fieldNumber.clear();
            Driver.clear();
            fieldNumberOfStorage.clear();
        });
    }

    private void  addView(){
        DatabaseHandler dbHandler=new DatabaseHandler();
        String typeOfCarText =fieldTypeOfCar.getText();
        String numberText=fieldNumber.getText();
        String driverText=Driver.getText();
        String numberOfStorage=fieldNumberOfStorage.getText();
        View view =new View(driverText,typeOfCarText,numberText,numberOfStorage);

        dbHandler.addView(view);
    }

    private void  addNewCar(){
        DatabaseHandler dbHandler=new DatabaseHandler();
        String typeOfCarText =fieldTypeOfCar.getText();
        String numberText=fieldNumber.getText();
        String driverText=Driver.getText();
        String numberOfStorage=fieldNumberOfStorage.getText();
        Car car =new Car(typeOfCarText,numberText,driverText,numberOfStorage);

        dbHandler.addCar(car);
    }

    private void deleteCar(){
        DatabaseHandler dbHandler=new DatabaseHandler();
        String typeOfCarText =deleteType.getText();
        String numberText=deleteNumber.getText();
        String driverText=deleteDriver.getText();
        String numberOfStorage=deleteStorage.getText();
        Car car =new Car(typeOfCarText,numberText,driverText,numberOfStorage);

        dbHandler.deleteCar(car);
    }
}