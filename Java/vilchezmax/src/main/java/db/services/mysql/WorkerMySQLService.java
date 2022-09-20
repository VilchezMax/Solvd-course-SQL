package db.services.mysql;


import db.dao.mysqldao.AreaMySQLDAO;
import db.dao.mysqldao.ExperimentMySQLDAO;
import db.dao.mysqldao.WorkerMySQLDAO;
import db.models.Worker;
import db.services.ICRUDServices;

import java.sql.SQLException;
import java.util.List;

public class WorkerMySQLService implements ICRUDServices<Worker> {
    WorkerMySQLDAO workerMySQLDAO;
    ExperimentMySQLDAO experimentsMySQLDAO;
    AreaMySQLDAO areasMySQLDAO;

    @Override
    public void create(Worker object) throws SQLException {
        object.setExperiments(experimentsMySQLDAO.getAllByWorkerId(object.getId()));
        object.setAreas(areasMySQLDAO.getAllByWorkerId(object.getId()));
        workerMySQLDAO.create(object);
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Worker worker = workerMySQLDAO.getById(id);
        worker.setExperiments(experimentsMySQLDAO.getAllByWorkerId(id));
        worker.setAreas(areasMySQLDAO.getAllByWorkerId(id));
        return worker;
    }

    @Override
    public void update(Worker object) {

    }

    @Override
    public void remove(Integer id) {
        workerMySQLDAO.remove(id);
    }

    @Override
    public List<Worker> getAll() {
        return null;
    }
}
