package db.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

// CREATE thread safe CONNECTION POOL with resources configuration
public class DBConnectionPool {
    private final Logger logger = LogManager.getLogger(DBConnectionPool.class);
    private List<DBConnection> availableConnections = new ArrayList<>();
    private List<DBConnection> usedConnections = new ArrayList<>();
    private static DBConnectionPool pool;
    private static int poolSize = 5;
    private BlockingQueue<DBConnection> queue;
    /* TODO: MODIFY THIS ATTRIBUTE FOR CHANGING CONNECTION SOURCE (REMOTE SOLVD DB) */
    private static final Connections CONNECTION_SOURCE = Connections.LOCAL;

    private DBConnectionPool() {
        this.initPool();
    }

    private void initPool() {
        try {
            for (int i = 1; i <= poolSize; i++) {
                logger.info("Creating connection " + i);
                DBConnection conn = new DBConnection(CONNECTION_SOURCE);
                availableConnections.add(conn);
            }
            logger.info("Connection pool was initialized.");
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    public static DBConnectionPool getInstance() {
        if (pool == null) {
            synchronized (DBConnectionPool.class) {
                if (pool == null) {
                    pool = new DBConnectionPool();
                }
            }
        }
        return pool;
    }

    public Connection getConnection() throws NullPointerException {
        boolean flag = false;
        DBConnection connection = null;
        if (availableConnections.size() > 0) {
            connection = availableConnections.get(0);
            availableConnections.remove(connection);
            usedConnections.add(connection);
        } else if (!flag) {
            try {
                Thread.sleep(5000);
                this.getConnection();
            } catch (InterruptedException e) {
                logger.warn(e);
            }
        }
        return connection.getConnection();
    }

}
