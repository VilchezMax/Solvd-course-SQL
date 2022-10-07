package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Substrate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubstrateMySQLDAO implements ICrudDAO<Substrate> {

    @Override
    public void create(Substrate object) throws SQLException {

    }

    @Override
    public Substrate getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Substrate object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Substrate> getAll() throws SQLException {
        return null;
    }

    @Override
    public Substrate extractData(ResultSet result) throws SQLException {
        return null;
    }
}

