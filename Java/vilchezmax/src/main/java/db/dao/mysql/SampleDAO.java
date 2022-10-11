package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Sample;

import java.sql.SQLException;
import java.util.List;

public class SampleDAO implements ICrudDAO<Sample> {

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
    public List<Sample> getAll() throws SQLException {
        return null;
    }

}

