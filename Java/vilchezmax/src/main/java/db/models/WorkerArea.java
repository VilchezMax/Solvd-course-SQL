package db.models;

import db.MySQLDAO;
import db.dao.IWorkerAreaDAO;

public class WorkerArea extends MySQLDAO implements IWorkerAreaDAO {
    private Integer id;
    private Integer areaId;
    private Integer workerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}
