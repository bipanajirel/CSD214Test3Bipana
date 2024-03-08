package com.example.csd214test3bipana;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Double.valueOf;


public class HelloController implements Initializable {
    public TextField iD;
    public TextField CustomerName;
    public TextField MobileNumber;
    public ComboBox PizzaSize;
    public TextField NumberOfToppings;
    public TextField TotalBill;
    @FXML
    private Label welcomeText;
    @FXML
    public TableView pizza;

    @FXML
    private TableColumn<Pizza, Integer> Id;
    @FXML
    private TableColumn<Pizza, String> customername;
    @FXML
    private TableColumn<Pizza, String> mobilenumber;
    @FXML
    private TableColumn<Pizza, String> pizzasize;
    @FXML
    private TableColumn<Pizza, Integer> numberoftoppings;
    @FXML
    private TableColumn<Pizza, Double> totalbill;
    ObservableList<Pizza> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new
                PropertyValueFactory<Pizza, Integer>("Id"));
        customername.setCellValueFactory(new
                PropertyValueFactory<Pizza, String>("CustomerName"));
        mobilenumber.setCellValueFactory(new
                PropertyValueFactory<Pizza, String>("MobileNumber"));
        pizzasize.setCellValueFactory(new
                PropertyValueFactory<Pizza, String>("PizzaSize"));
        numberoftoppings.setCellValueFactory(new
                PropertyValueFactory<Pizza, Integer>("NumberOfToppings"));
        totalbill.setCellValueFactory(new
                PropertyValueFactory<Pizza, Double>("TotalBill"));
        pizza.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {populateTable();}

    public void populateTable() {
        // Establish a database connection

        list.clear();
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test_3bipana";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM pizza";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int Id = resultSet.getInt("ID");
                String CustomerName = resultSet.getString("CustomerName");
                String MobileNumber = resultSet.getString("MobileNumber");
                String PizzaSize = resultSet.getString("PizzaSize");
                int NumberOfToppings  = resultSet.getInt("NumberOfToppings");
                double TotalBill = resultSet.getDouble("TotalBill");
                pizza.getItems().add(new Pizza(Id, CustomerName, MobileNumber, PizzaSize, NumberOfToppings,TotalBill));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void AddData(ActionEvent actionEvent) {
        String customername = CustomerName.getText();
        String mobilenumber = MobileNumber.getText();
        String pizzasize = PizzaSize.getItems().toString();
        Integer numberoftoppings  = Integer.valueOf(NumberOfToppings.getText());
        Double totalbill= Double.valueOf(TotalBill.getText());
        InserTable(customername, mobilenumber, pizzasize, numberoftoppings, totalbill);

    }

    private void InserTable(String customername,String mobilenumber, String pizzasize, Integer numberoftoppings, Double totalbill) {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test_3bipana";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `pizza`(`CustomerName`, `MobileNumber`, `PizzaSize`,`NumberOfToppings`,`TotalBill`) VALUES ('" + customername + "','" + mobilenumber + "','" + pizzasize + "','" + numberoftoppings + "','"+ totalbill +"')";
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable();
    }

    public void DeleteData(ActionEvent actionEvent) {
        Integer Id = Integer.valueOf(iD.getText());
        DeleteTable(Id);
    }

    private void DeleteTable(Integer Id) {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test_3bipana";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `pizza` WHERE `ID`='" + Id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable();
    }

    public void UpdateData(ActionEvent actionEvent) {
        Integer Id = Integer.valueOf(iD.getText());
        String customername = CustomerName.getText();
        String mobilenumber = MobileNumber.getText();
        String pizzasize = PizzaSize.getItems().toString();
        Integer numberoftoppings  = Integer.valueOf(NumberOfToppings.getText());
        Double totalbill= valueOf(TotalBill.getText());
        UpdateTable(Id,customername, mobilenumber,pizzasize,numberoftoppings,totalbill);

    }

    private void UpdateTable(Integer Id, String customername, String mobilenumber, String pizzasize,Integer numberoftoppings,Double totalbill) {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test_3bipana";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "UPDATE `pizza` SET `CustomerName`='" + customername + "',`MobileNumber`='" + mobilenumber + "',`PizzaSize`='" + pizzasize+ "',`NumberOfToppings`='" +numberoftoppings+ "',`TotalBill`='" +totalbill+ "' WHERE `ID`='" + Id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable();
    }

    public void LoadData(ActionEvent actionEvent) {
        Integer Id = Integer.valueOf(iD.getText());
        LoadTable(Id);
    }

    private void LoadTable(Integer Id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214test_3bipana";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM pizza WHERE `ID`='" + Id + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String customername = resultSet.getString("CustomerName");
                String mobilenumber = resultSet.getString("MobileNUmber");
                String pizzasize = resultSet.getString("PizzaSize");
                int numberoftoppings = resultSet.getInt("NumberOfToppings");
                double totalbill = resultSet.getDouble("TotalBill");

                CustomerName.setText(customername);
                MobileNumber.setText(mobilenumber);
                PizzaSize.setValue(pizzasize);
                NumberOfToppings.setText(String.valueOf(numberoftoppings));
                TotalBill.setText(String.valueOf(totalbill));



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable();
    }


}






