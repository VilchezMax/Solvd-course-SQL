package db.models;

import db.MySQLDAO;
import db.dao.IWorkerExperimentDAO;

public class WorkerExperiment extends MySQLDAO implements IWorkerExperimentDAO {
    private Integer id;
    private Integer workerId;
    private Integer experimentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }
}
