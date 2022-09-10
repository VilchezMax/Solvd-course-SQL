package db.models;

import db.MySQLDAO;
import db.dao.IWorkerExperimentDAO;

public class WorkerExperiment  extends MySQLDAO implements IWorkerExperimentDAO {
    private Long id;
    private Long workerId;
    private Long experimentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }
}
