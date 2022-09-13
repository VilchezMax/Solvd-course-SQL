package db.dao.mysql;

import db.models.Worker;

import java.util.List;

public interface IWorkerDAO extends IBaseDAO<Worker> {
    List<Worker> getAll();
}
