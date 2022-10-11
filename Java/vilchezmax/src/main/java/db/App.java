package db;

import db.jdbc.DBConnectionPool;
import db.models.Entities;
import db.models.Worker;
import db.services.ICrudServices;
import db.services.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        try {
            /*Test connection*/
            DBConnectionPool connectionPool = DBConnectionPool.getInstance();
            connectionPool.getConnection();

            /*Test Service*/
            ICrudServices<Worker> workerService = ServiceFactory.getService("mybatis", Entities.WORKER.getClassValue());

//          workerService.remove(4);
//          List<Worker> workers = workerService.getAll();
            Worker worker = workerService.getById(1);

            /* not using toString because some complex objects aren't brought yet.*/
            logger.log(Level.getLevel("SUCCESS"),
                    "\nWorker fetched from database:"
                            + "\nID: " + worker.getId()
                            + "\nName: " + worker.getFirstName()
                            + "\nSurname: " + worker.getLastName()
                            + "\nBirthdate: " + worker.getBirthDate());


        } catch (SQLException | ClassNotFoundException | NoSuchMethodException |
                 InvocationTargetException | InstantiationException | IllegalAccessException e) {
            logger.info(e.getMessage());
        }
    }
}
