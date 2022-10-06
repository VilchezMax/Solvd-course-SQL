package db.jdbc;

import java.sql.Connection;

public class TestJDBC {
    public static void main(String[] args) {
        DBConnectionPool pool = DBConnectionPool.getInstance();
        Connection conn = pool.getConnection();

    }
}
