package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"
                + dbPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void signUpUser(User user){
     String insert = "INSERT INTO " + Const.USER_TABLE +
             "(" + Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," +
             Const.USER_STATUS + ")"
             + "VALUES(?,?,?)";
     try {
        PreparedStatement prSt= getDbConnection().prepareStatement(insert);
        prSt.setString(1,user.getLogin());
        prSt.setString(2,user.getPassword());
        prSt.setString(3,user.getStatus());

        prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user){
        String select = "DELETE FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=? AND "
                + Const.USER_STATUS + "=?";

        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getStatus());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet=null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
               Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=? AND "
                + Const.USER_STATUS + "=?";

        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getStatus());

           resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
    public void addCar(Car car){
        String insert = "INSERT INTO " + Const.CAR_TABLE +
                "(" + Const.CAR_TYPE + "," + Const.CAR_NUMBER + "," +
                Const.CAR_DRIVER + "," + Const.CAR_STORAGE + ")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1,car.getTypeOfCar());
            prSt.setString(2, car.getNumberOfCar());
            prSt.setString(3, car.getDriver());
            prSt.setString(4, car.getNumberOfStorage());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addView(View view){
        String insert = "INSERT INTO " + Const.VIEW_TABLE +
                "(" + Const.VIEW_DRIVER + "," + Const.VIEW_TYPE + "," +
                Const.VIEW_NUMBER + "," + Const.VIEW_STORAGE + ")"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1, view.getDriver());
            prSt.setString(2, view.getType());
            prSt.setString(3, view.getNumber());
            prSt.setString(4, view.getNumberStorage());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void deleteCar(Car car){
        String select = "DELETE FROM " + Const.CAR_TABLE + " WHERE " +
                Const.CAR_TYPE + "=? AND " + Const.CAR_NUMBER + "=? AND "
                + Const.CAR_DRIVER + "=? AND " + Const.CAR_STORAGE + "=?";

        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(select);
            prSt.setString(1,car.getTypeOfCar());
            prSt.setString(2,car.getNumberOfCar());
            prSt.setString(3,car.getDriver());
            prSt.setString(4,car.getNumberOfStorage());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectAllOrders() {
        ResultSet result = null;
        String select = "SELECT * FROM " + dbName + "." + Const.CAR_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            result = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet selectAllUsers() {
        ResultSet result = null;
        String select = "SELECT * FROM " + dbName + "." + Const.USER_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            result = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


}
