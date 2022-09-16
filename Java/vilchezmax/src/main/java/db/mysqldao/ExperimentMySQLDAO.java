package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Experiment;

import java.sql.SQLException;
import java.util.List;

public class ExperimentMySQLDAO implements IBaseDAO<Experiment> {

    @Override
    public void create(Experiment object) throws SQLException {

    }

    @Override
    public Experiment getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Experiment object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Experiment> getAll() throws SQLException {
        return null;
    }
}

