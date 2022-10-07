package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Seniority;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SeniorityMySQLDAO implements ICrudDAO<Seniority> {

    @Override
    public void create(Seniority object) throws SQLException {

    }

    @Override
    public Seniority getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Seniority object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Seniority> getAll() throws SQLException {
        return null;
    }

    @Override
    public Seniority extractData(ResultSet result) throws SQLException {
        return null;
    }
}

