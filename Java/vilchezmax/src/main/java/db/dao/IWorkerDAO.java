package db.dao;

import db.models.Worker;

import java.util.Map;

public interface IWorkerDAO extends IBaseDAO<Worker> {
    Map<Integer, Worker> getAll();
}
