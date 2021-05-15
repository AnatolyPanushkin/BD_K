package User;
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
import sample.View;

public class ViewTable {
    private ObservableList<View> orderObservableList = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<View> ViewTable;

    @FXML
    private TableColumn<View, String> driver;

    @FXML
    private TableColumn<View, String> type;

    @FXML
    private TableColumn<View, String> number;

    @FXML
    private TableColumn<View, String> nbrStorage;

    @FXML
    void initialize() {
        initData();
        driver.setCellValueFactory(new PropertyValueFactory<View, String>("driver"));
        type.setCellValueFactory(new PropertyValueFactory<View, String>("type"));
        number.setCellValueFactory(new PropertyValueFactory<View, String>("number"));
        nbrStorage.setCellValueFactory(new PropertyValueFactory<View, String>("numberStorage"));

        ViewTable.setItems(orderObservableList);

    }
    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllOrders();
        try {
            while (res.next()) {
                orderObservableList.add(new View(res.getString("typeOfCar"),res.getString("numberOfCar"),
                        res.getString("driver"),res.getString("numberOfStorage")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
