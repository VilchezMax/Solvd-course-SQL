package db.jdbc;

import java.sql.Connection;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DBConnectionPool.getInstance().getConnection();
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
