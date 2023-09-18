package BookCar;

import connection.ConnectionClass;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class bookDB {
    public ObservableList fetchIsbCarTable(ObservableList<Car> memList) {

        try {
            Connection connection = ConnectionClass.getConnection();
            ResultSet statement = connection.createStatement().executeQuery("select * from islamabadcars");

            while(statement.next()) {
                memList.add(new Car(statement.getString("sector"), statement.getString("type"), statement.getInt("model"),
                        statement.getInt("number"), statement.getString("color"), statement.getInt("available")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BookNowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return memList;
    }

    PreparedStatement pst = null;
    public PreparedStatement setBookTable() {
        try {
            Connection connection = ConnectionClass.getConnection();
            pst = connection.prepareStatement("insert into bookings (carNo)values(?)");
            // JOptionPane.showMessageDialog(null, "Connection Established");
            return pst;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
