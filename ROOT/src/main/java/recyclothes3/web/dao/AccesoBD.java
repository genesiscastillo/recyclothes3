package recyclothes3.web.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBD {

    public static final Logger LOGGER = Logger.getLogger(AccesoBD.class);
    private static AccesoBD accesoBD;

    public static AccesoBD getInstance(){
        if(accesoBD == null){
            accesoBD = new AccesoBD();
        }
        return accesoBD;
    }
/*
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.info("Where is your MySQL JDBC Driver?");
        }
    }
*/

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/web","adminvlRnXQp", "3isUfI-lcxI7");
        } catch (SQLException e) {
            LOGGER.error("Connection Failed! Check output console "+e.getMessage());
        }
        return connection;
    }
}
