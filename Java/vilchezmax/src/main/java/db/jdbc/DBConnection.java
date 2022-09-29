package db.jdbc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Properties;

public class DBConnection {
    final Logger logger = LogManager.getLogger(DBConnection.class);

    Connection conn = null;

    protected DBConnection(Connections connection) {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream(connection.getPropertiesPath()));
            //get Driver
            Class.forName(props.getProperty("driver"));
            // get Connection
            conn = DriverManager.getConnection(
                    props.getProperty("protocol") + props.getProperty("host") + ":" + props.getProperty("port") + "/" + props.getProperty("dbname"),
                    props.getProperty("user"),
                    props.getProperty("password"));
            if (conn != null) {
                try (PreparedStatement st = conn.prepareStatement("SELECT NOW()")) {
                    Instant time = st.executeQuery().getDate(1).toInstant();
                    logger.log(Level.getLevel("SUCCESS"),
                            "Connection to " + props.getProperty("dbname") + " database was successful - " + time.toString());
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
            conn.close();
        } catch (SQLException e) {
            logger.warn(e);
        }
    }
}
