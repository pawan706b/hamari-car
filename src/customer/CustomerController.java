package customer;


import BookCar.BookNowController;
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

import java.io.IOException;


public class CustomerController {
    private customerDB objDB = new customerDB();
    @FXML
    private TableView<BookingHist> tableBookCarHst;
    @FXML
    private TableColumn<BookingHist, Integer> colCarNo;


    ObservableList<BookingHist> bookingsList = FXCollections.observableArrayList();
    public void showBookings(){

        bookingsList = objDB.fetchBookingsTable(bookingsList);
        colCarNo.setCellValueFactory((new PropertyValueFactory<>("carNo")));

        tableBookCarHst.setItems(bookingsList);
    }
    @FXML
    void bookAdvPressed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../BookCar/bookAdv.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }

    @FXML
    void bookHistPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../customer/bookingHistory.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        CustomerController obj = loader.getController();
        obj.showBookings();

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    @FXML
    void bookNowPressed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../BookCar/bookNow.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    @FXML
    void bookHistBackPressed(ActionEvent event) throws IOException{
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
