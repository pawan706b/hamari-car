package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static Connection getConnection() throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/hamaricar", "root", "1234");
        return connection;
    }
}
