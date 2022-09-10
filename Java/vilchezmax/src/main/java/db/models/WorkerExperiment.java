package db.models;

import db.MySQLDAO;
import db.dao.IWorkerExperimentDAO;

public class WorkerExperiment  extends MySQLDAO implements IWorkerExperimentDAO {
    private Long id;
    private Worker worker;
    private Experiment experiment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }
}
