package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Seniority;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class SeniorityMySQLDAO implements IBaseDAO<Seniority> {

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
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

