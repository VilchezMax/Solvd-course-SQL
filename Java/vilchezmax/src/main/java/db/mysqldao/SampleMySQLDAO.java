package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Sample;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class SampleMySQLDAO implements IBaseDAO<Sample> {

    @Override
    public void create(Sample object) throws SQLException {

    }

    @Override
    public Sample getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Sample object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

