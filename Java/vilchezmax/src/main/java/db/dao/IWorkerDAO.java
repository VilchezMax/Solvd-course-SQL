package db.dao;

import db.models.Worker;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface IWorkerDAO extends ICrudDAO<Worker> {
    @Override
    void create(@Param("Worker")Worker object) throws SQLException;

    @Override
    Worker getById(@Param("id")Integer id) throws SQLException;

    @Override
    void update(@Param("Worker")Worker object) throws SQLException;

    @Override
    void remove(Integer id) throws SQLException;

    @Override
    List<Worker> getAll() throws SQLException;
}

