package db;

import db.jdbc.DBConnectionPool;
import db.models.Worker;
import db.services.mysql.WorkerService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        //TRY CONNECTION POOL WITH LOCAL CONFIGURATION
        DBConnectionPool connectionPool = DBConnectionPool.getInstance();
        connectionPool.getConnection();

        //CALL WORKER FROM WORKERMYSQLSERVICE
        WorkerService workerMySQLService = new WorkerService();
        Worker worker = workerMySQLService.getById(1);
        System.out.println(worker);
    }
}
