package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Kingdom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KingdomMySQLDAO implements ICrudDAO<Kingdom> {

    @Override
    public void create(Kingdom object) throws SQLException {

    }

    @Override
    public Kingdom getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Kingdom object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Kingdom> getAll() throws SQLException {
        return null;
    }

    @Override
    public Kingdom extractData(ResultSet result) throws SQLException {
        return null;
    }
}

