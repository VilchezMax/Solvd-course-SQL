package db.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;

// CREATE thread safe CONNECTION POOL with resources configuration
public class DBConnectionPool {
    final Logger logger = LogManager.getLogger(DBConnectionPool.class);
    private List<DBConnection> availableConnections = new ArrayList<>();
    private List<DBConnection> usedConnections = new ArrayList<>();
    private static DBConnectionPool pool;
    private BlockingQueue<DBConnection> queue;
    private static Connections connectionSource = Connections.LOCAL; // TODO: MODIFY THIS ATTRIBUTE FOR CHANGING CONNECTION SOURCE (REMOTE SOLVD DB)

    private DBConnectionPool() {
        this.connectionSource = connectionSource;
        initPool();
    }

    private void initPool() {
        Properties props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream(connectionSource.getPropertiesPath()));
            int poolSize = Integer.parseInt(props.getProperty("pool_size"));
            for (int i = 0; i < poolSize; i++) {
                availableConnections.add(new DBConnection(connectionSource));
            }
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    public static DBConnectionPool getInstance() {
        if (pool == null) {
            synchronized (DBConnectionPool.class) {
                if (pool == null) {
                    pool = new DBConnectionPool();
                    pool.initPool();
                }
            }
        }
        return pool;
    }

    public Connection getConnection() {
        DBConnection connection = null;
        if (availableConnections.size() > 0) {
            connection = availableConnections.get(0);
            availableConnections.remove(connection);
            usedConnections.add(connection);
        } else {
            try {
                Thread.sleep(5000);
                getConnection();
            } catch (InterruptedException e) {
                logger.warn(e);
            }
        }
        return connection.getConnection();
    }

}
