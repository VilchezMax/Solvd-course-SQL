package db.services.mybatis;

import db.dao.mybatis.WorkerDAO;
import db.models.Worker;
import db.services.ICrudServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class WorkerService implements ICrudServices<Worker> {
    final Logger LOGGER = LogManager.getLogger(WorkerService.class);
    WorkerDAO workerDAO = new WorkerDAO();

    @Override
    public void create(Worker worker) {
        try {
            workerDAO.create(worker);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Override
    public Worker getById(Integer id) {
        Worker worker = null;
        try {
            worker = workerDAO.getById(id);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return worker;
    }

    @Override
    public void update(Worker worker) {
        try {
            workerDAO.update(worker);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        try {
            workerDAO.remove(id);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Override
    public List<Worker> getAll() {
        List<Worker> workers = null;
        try {
            workers = workerDAO.getAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return workers;
    }
}
