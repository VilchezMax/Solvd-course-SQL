package db.dao;

import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public interface IWorkerDAO extends ICrudDAO<Worker> {
    @Override
    void create(Worker object) throws SQLException;

    @Override
    Worker getById(Integer id) throws SQLException;

    @Override
    void update(Worker object) throws SQLException;

    @Override
    void remove(Integer id) throws SQLException;

    @Override
    List<Worker> getAll() throws SQLException;
}

