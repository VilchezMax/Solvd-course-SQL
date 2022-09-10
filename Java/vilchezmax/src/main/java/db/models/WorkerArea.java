package db.models;

import db.MySQLDAO;
import db.dao.IWorkerAreaDAO;

public class WorkerArea  extends MySQLDAO implements IWorkerAreaDAO {
    private Long id;
    private Area area;
    private Worker worker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
