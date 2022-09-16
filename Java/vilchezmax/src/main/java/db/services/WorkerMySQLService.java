package db.services;


import db.dao.IBaseDAO;
import db.models.Area;
import db.models.Experiment;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class WorkerMySQLService implements IBaseDAO<Worker> {
    Worker worker;
    Experiment experiments;
    Area areas;

    @Override
    public void create(Worker object) throws SQLException {

    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        worker = worker.getById(id);
        //worker.setExperiments(experiments.getExperimentByWorkerId()); TODO
        //worker.setAreas(areas.getAreasByWorkerId()); TODO

        return worker;
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
