package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SolvdConnection {
    private String dbName = "science_laboratory";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:8888/" + dbName + "?useUnicode=true&use"
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
                System.out.println("Connection to " + dbName + " successful.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
