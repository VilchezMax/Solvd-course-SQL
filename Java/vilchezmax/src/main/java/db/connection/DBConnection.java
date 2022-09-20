package db.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;

public class DBConnection {
    final Logger logger = LogManager.getLogger(DBConnection.class);

    Connection conn = null;

    public DBConnection(Connections dbConnection) {
        try {
            //get Driver
            Class.forName(dbConnection.getDriver()).getDeclaredConstructor().newInstance();
            // get Connection
            conn = DriverManager.getConnection(
                    dbConnection.getURL(),
                    dbConnection.getUser(),
                    dbConnection.getPassword());
            if (conn != null) {
                try (PreparedStatement st = conn.prepareStatement("SELECT NOW()")) {
                    Instant time = st.executeQuery().getDate(1).toInstant();
                    logger.info("Connection to " + dbConnection.getDbName() + " database was successful - " + time.toString());
                }

            }
        } catch (ClassNotFoundException | SQLException | InvocationTargetException
                | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            logger.info(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
