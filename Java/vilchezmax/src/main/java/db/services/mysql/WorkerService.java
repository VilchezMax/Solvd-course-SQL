package db.services.mysql;


import db.dao.mysql.AreaDAO;
import db.dao.mysql.ExperimentDAO;
import db.dao.mysql.WorkerDAO;
import db.models.*;
import db.services.ICrudServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class WorkerService implements ICrudServices<Worker> {
    private static final Logger logger = LogManager.getLogger(WorkerService.class);

    private WorkerDAO workerDAO = new WorkerDAO();
    private ExperimentDAO experimentsDAO = new ExperimentDAO();
    private AreaDAO areasDAO = new AreaDAO();

    @Override
    public void create(Worker worker) {
        try {
//            worker.setExperiments(experimentsDAO.getAllByWorkerId(worker.getId()));
//            worker.setAreas(areasDAO.getAllByWorkerId(worker.getId()));
            workerDAO.create(worker);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public Worker getById(Integer id) {
        Worker worker = null;
        try {
            worker = workerDAO.getById(id);
            logger.info(worker);
//            worker.setExperiments(experimentsDAO.getAllByWorkerId(id));
//            worker.setAreas(areasDAO.getAllByWorkerId(id));
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return worker;
    }

    @Override
    public void update(Worker worker) {
        try {
            workerDAO.update(worker);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void remove(Integer id) {
        try {
            workerDAO.remove(id);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public List<Worker> getAll() {
        ArrayList<Worker> workers = null;

        List<Experiment> experiments = null;
        TestSubject testSubject = null;
        Substrate substrate = null;

        List<Area> areas = null;
        LabWing labWing = null;
        try {
            workers = workerDAO.getAll();
            for (Worker worker : workers) {

                worker.setExperiments(experimentsDAO.getAllByWorkerId(worker.getId()));
                worker.setAreas(areasDAO.getAllByWorkerId(worker.getId()));
            } //TOTALLY  INEFFICIENT, BUT FIRST MAKE IT WORK.
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return workers;
    }
}
