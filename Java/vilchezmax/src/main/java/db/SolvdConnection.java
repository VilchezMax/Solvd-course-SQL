package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SolvdConnection {
    final Logger logger = LogManager.getLogger(Connection.class);

    private String dbName = "science_laboratory";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysqldao://localhost:8888/" + dbName + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    Connection conn = null;

    public SolvdConnection() {
        try {
            //get Driver
            Class.forName("com.mysql.jdbc.Driver");
            // get Connection
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                logger.info("Connection to " + dbName + " database was successful.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
