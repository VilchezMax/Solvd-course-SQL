package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.LabWing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LabWingMySQLDAO implements ICrudDAO<LabWing> {

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
    public List<LabWing> getAll() throws SQLException {
        return null;
    }

    @Override
    public LabWing extractData(ResultSet result) throws SQLException {
        return null;
    }
}

