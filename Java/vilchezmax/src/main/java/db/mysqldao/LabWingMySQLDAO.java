package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.LabWing;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class LabWingMySQLDAO implements IBaseDAO<LabWing> {

    @Override
    public void create(LabWing object) throws SQLException {

    }

    @Override
    public LabWing getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(LabWing object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

