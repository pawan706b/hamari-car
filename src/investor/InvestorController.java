package investor;

import BookCar.BookNowController;
import BookCar.Car;
import BookCar.bookDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;

public class InvestorController {

    private investorDB objDB = new investorDB();
    @FXML
    private TableView<Car> tableIsbCar;
    @FXML
    private TableColumn<Car, String> colSector;
    @FXML
    private TableColumn<Car, String> colType;
    @FXML
    private TableColumn<Car, Integer> colModel;
    @FXML
    private TableColumn<Car, Integer> colNumber;
    @FXML
    private TableColumn<Car, String> colColor;
    @FXML
    private TextField txtSector;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtModel;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtColor;

    PreparedStatement pst = null;

    ObservableList<Car> isbCarList = FXCollections.observableArrayList();

    public void showInvestedCarList(){

        isbCarList = objDB.fetchInvestedCarTable(isbCarList);
        colSector.setCellValueFactory((new PropertyValueFactory<>("sector")));
        colType.setCellValueFactory((new PropertyValueFactory<>("type")));
        colModel.setCellValueFactory((new PropertyValueFactory<>("model")));
        colNumber.setCellValueFactory((new PropertyValueFactory<>("number")));
        colColor.setCellValueFactory((new PropertyValueFactory<>("color")));

        tableIsbCar.setItems(isbCarList);
    }

    @FXML
    void investPressed(ActionEvent event) {
        try {
            pst = objDB.setIsbCarsTable();

            pst.setString(1, txtSector.getText());
            pst.setString(2, txtType.getText());
            pst.setInt(3, Integer.parseInt(txtModel.getText()));
            pst.setInt(4, Integer.parseInt(txtNumber.getText()));
            pst.setString(5, txtColor.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Car Invested successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // add(event);
    }


    @FXML
    void investCarPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../investor/investCarView.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    @FXML
    void showInvestmentsPressed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../investor/investedCarsView.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        InvestorController obj = loader.getController();
        obj.showInvestedCarList();

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }


    @FXML
    void investBackPressed(ActionEvent event) throws IOException{
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("../investor/investorView.fxml"));
        Scene sampleViewScene = new Scene(passwordViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(sampleViewScene);
        window.show();

    }

    public void sample_view(ActionEvent event) throws IOException {
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
        Scene sampleViewScene = new Scene(passwordViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(sampleViewScene);
        window.show();

    }
}
