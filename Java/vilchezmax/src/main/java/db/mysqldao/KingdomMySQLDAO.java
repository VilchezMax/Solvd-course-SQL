package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Kingdom;

import java.sql.SQLException;
import java.util.List;

public class KingdomMySQLDAO implements IBaseDAO<Kingdom> {

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
}

