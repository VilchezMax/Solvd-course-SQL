package db.models;

import db.MySQLDAO;
import db.dao.IWorkerAreaDAO;

public class WorkerArea  extends MySQLDAO implements IWorkerAreaDAO {
    private Long id;
    private Long areaId;
    private Long workerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
