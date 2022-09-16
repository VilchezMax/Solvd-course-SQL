package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class ClassMySQLDAO implements IBaseDAO<Class> {

    @Override
    public void create(Class object) throws SQLException {

    }

    @Override
    public Class getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Class object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

