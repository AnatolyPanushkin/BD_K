package Operator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Car;
import sample.DatabaseHandler;

public class CarTable {
    private ObservableList<Car> orderObservableList = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Car> CarTable;

    @FXML
    private TableColumn<Car, String> columnType;

    @FXML
    private TableColumn<Car, String> columnNumber;

    @FXML
    private TableColumn<Car, String> columnDriver;

    @FXML
    private TableColumn<Car, String> columnStorage;

    @FXML
    void initialize() {
        initData();
        columnType.setCellValueFactory(new PropertyValueFactory<Car, String>("typeOfCar"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<Car, String>("numberOfCar"));
        columnDriver.setCellValueFactory(new PropertyValueFactory<Car, String>("driver"));
        columnStorage.setCellValueFactory(new PropertyValueFactory<Car, String>("numberOfStorage"));

        CarTable.setItems(orderObservableList);

    }
    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllOrders();
        try {
            while (res.next()) {
                orderObservableList.add(new Car(res.getString("typeOfCar"),res.getString("numberOfCar"),
                        res.getString("driver"),res.getString("numberOfStorage")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

