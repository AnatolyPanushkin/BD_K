package Admin;

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
import sample.User;


public class UserTable {

    private ObservableList<User> orderObservableList = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> columnLogin;

    @FXML
    private TableColumn<User, String> columnPassword;

    @FXML
    private TableColumn<User, String> columnStatus;

    @FXML
    void initialize() {
        initData();
        columnLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<User, String>("status"));


        userTable.setItems(orderObservableList);
    }

    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllUsers();
        try {
            while (res.next()) {
                orderObservableList.add(new User(res.getString("login"),res.getString("password"),
                        res.getString("status")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
