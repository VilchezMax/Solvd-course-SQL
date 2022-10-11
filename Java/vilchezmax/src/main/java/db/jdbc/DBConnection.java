package db.jdbc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    final Logger logger = LogManager.getLogger(DBConnection.class);

    Connection conn = null;

    public DBConnection(Connections connection) {
        Properties props = new Properties();
        try {
            FileInputStream propsFile = new FileInputStream(connection.value());
            props.load(propsFile);
            //get Driver
            Class.forName(props.getProperty("driver"));
            // get Connection
            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("user"),
                    props.getProperty("password"));
            if (conn != null) {
                try (PreparedStatement st = conn.prepareStatement("SELECT NOW()")) {
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        Date time = rs.getDate(1);
                        logger.log(Level.getLevel("SUCCESS"),
                                "Connection to " + props.getProperty("dbname") +
                                        " database was successful."); //+ Thread.currentThread().getName());
                    }
                } catch (SQLException e) {
                    logger.warn(e);
                }

            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.info(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            logger.info("Closing connection to database.");
            conn.close();
        } catch (SQLException e) {
            logger.warn(e);
        }
    }
}
