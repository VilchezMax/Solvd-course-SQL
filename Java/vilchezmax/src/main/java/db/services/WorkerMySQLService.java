package db.services;

import db.dao.mysql.IWorkerDAO;
import db.models.Area;
import db.models.Experiment;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class WorkerMySQLService extends MySQLWorkerDAO implements IWorkerDAO {
    Worker worker;
    Experiment experiments;
    Area areas;

    @Override
    public void create(Worker object) throws SQLException {

    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        worker = worker.getById(id);
        worker.setExperiments(experiments.getExperimentByWorkerId());
        worker.setAreas(areas.getAreasByWorkerId());

        return null;
    }

    @Override
    public void update(Worker object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Worker> getAll() {
        return null;
    }
}
