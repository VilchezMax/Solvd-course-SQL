package db.services.mysql;


import db.dao.mysql.AreaMySQLDAO;
import db.dao.mysql.ExperimentMySQLDAO;
import db.dao.mysql.WorkerMySQLDAO;
import db.models.Worker;
import db.services.ICrudServices;

import java.sql.SQLException;
import java.util.List;

public class WorkerService implements ICrudServices<Worker> {
    WorkerMySQLDAO workerMySQLDAO = new WorkerMySQLDAO();
    ExperimentMySQLDAO experimentsMySQLDAO;
    AreaMySQLDAO areasMySQLDAO;

    @Override
    public void create(Worker worker) throws SQLException {
        worker.setExperiments(experimentsMySQLDAO.getAllByWorkerId(worker.getId()));
        worker.setAreas(areasMySQLDAO.getAllByWorkerId(worker.getId()));
        workerMySQLDAO.create(worker);
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Worker worker = workerMySQLDAO.getById(id);
        System.out.println(worker);
//        worker.setExperiments(experimentsMySQLDAO.getAllByWorkerId(id));
//        worker.setAreas(areasMySQLDAO.getAllByWorkerId(id));
        return worker;
    }

    @Override
    public void update(Worker worker) {

    }

    @Override
    public void remove(Integer id) throws SQLException {
        workerMySQLDAO.remove(id);
    }

    @Override
    public List<Worker> getAll() {
        return null;
    }
}
