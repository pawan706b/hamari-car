package customer;

import BookCar.BookNowController;
import connection.ConnectionClass;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class customerDB {
    public ObservableList fetchBookingsTable(ObservableList<BookingHist> memList) {

        try {
            Connection connection = ConnectionClass.getConnection();
            ResultSet statement = connection.createStatement().executeQuery("select * from bookings");

            while(statement.next()) {
                memList.add(new BookingHist(statement.getInt("carNo")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BookNowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return memList;
    }
}
