package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class Controller {

    public void submitCustPressed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../customer/customerController.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    public void submitInvestPressed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../investor/investorView.fxml"));

        Parent sampleViewParent = loader.load();
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    public void passwordCustomer(ActionEvent event) throws IOException {
        Parent sampleViewParent = FXMLLoader.load(getClass().getResource("PasswordView.fxml"));
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }
    public void passwordInvestor(ActionEvent event) throws IOException {
        Parent sampleViewParent = FXMLLoader.load(getClass().getResource("PasswordViewInvestor.fxml"));
        Scene passwordViewScene = new Scene(sampleViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(passwordViewScene);
        window.show();
    }

    public void sample_view(ActionEvent event) throws IOException {
        Parent passwordViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene sampleViewScene = new Scene(passwordViewParent, 900, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();    //getting the previous paren scene
        window.setTitle("Hamari Car");
        window.setScene(sampleViewScene);
        window.show();

    }
}
