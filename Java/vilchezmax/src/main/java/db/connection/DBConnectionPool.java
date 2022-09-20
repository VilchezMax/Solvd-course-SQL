package db.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public final class DBConnectionPool {
    private final Logger logger = LogManager.getLogger(DBConnectionPool.class);

    private static volatile DBConnectionPool connectionPool;
    private final int INITIAL_CONNECTIONS = 5;
    private final int MAX_CONNECTIONS = 5; //TODO: VER COMO INICIALIZARLO DE MANERA VARIABLE PERO EN SINGLETON
    private final Connections connectionData = Connections.LOCAL;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static List<Connection> idleConnections = new ArrayList<>();

    public int getINITIAL_CONNECTIONS() {
        return INITIAL_CONNECTIONS;
    }

    public int getMAX_CONNECTIONS() {
        return MAX_CONNECTIONS;
    }

    private DBConnectionPool() {
    }

    public static DBConnectionPool getInstance() {
        DBConnectionPool pool = connectionPool;
        if (pool != null) {
            return pool;
        }
        synchronized (DBConnectionPool.class) {
            if (connectionPool == null) {
                connectionPool = new DBConnectionPool();
            }
            return connectionPool;
        }
    }

    private void initPool(int INITIAL_CONNECTIONS) {
        for (int i = 0; i < INITIAL_CONNECTIONS; i++) {
            idleConnections.add(new DBConnection(connectionData).getConnection());
        }
    }

    public Connection getConnection() {
        if (idleConnections.isEmpty() && usedConnections.size() < connectionPool.MAX_CONNECTIONS) {
            return new DBConnection(connectionData).getConnection(); //TODO: LINK TO ANY LIST.
        } else if (true) {
            return null;//TODO
        } else {
            return null;//TODO
        }
    }
}
