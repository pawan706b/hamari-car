package BookCar;

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
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.PreparedStatement;

public class BookNowController {

    private bookDB objDB = new bookDB();
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
    private TextField txtCarNo;


    ObservableList<Car> isbCarList = FXCollections.observableArrayList();

    public void showIsbCarList(){

        isbCarList = objDB.fetchIsbCarTable(isbCarList);
        colSector.setCellValueFactory((new PropertyValueFactory<>("sector")));
        colType.setCellValueFactory((new PropertyValueFactory<>("type")));
        colModel.setCellValueFactory((new PropertyValueFactory<>("model")));
        colNumber.setCellValueFactory((new PropertyValueFactory<>("number")));
        colColor.setCellValueFactory((new PropertyValueFactory<>("color")));

        tableIsbCar.setItems(isbCarList);
    }

    PreparedStatement pst = null;

    @FXML
    void bookCarNowPressed(ActionEvent event) {
        try {
            pst = objDB.setBookTable();

            pst.setInt(1, Integer.parseInt(txtCarNo.getText()));
            pst.execute();

            JOptionPane.showMessageDialog(null, "Car Booked successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // add(event);
    }

    @FXML
    void islamabadAdvPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../BookCar/carsIsbAdv.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        BookNowController obj = loader.getController();
        obj.showIsbCarList();

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }

    @FXML
    void islamabadPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../BookCar/carsIslamabad.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        BookNowController obj = loader.getController();
        obj.showIsbCarList();

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }


    @FXML
    void bookBackPressed(ActionEvent event) throws IOException{
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("../BookCar/bookNow.fxml"));
        Scene sampleViewScene = new Scene(passwordViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(sampleViewScene);
        window.show();

    }

    @FXML
    void bookAdvBackPressed(ActionEvent event) throws IOException{
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("../BookCar/bookAdv.fxml"));
        Scene sampleViewScene = new Scene(passwordViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(sampleViewScene);
        window.show();

    }

    @FXML
    void backPressed(ActionEvent event) throws IOException{
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("../customer/customerController.fxml"));
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
