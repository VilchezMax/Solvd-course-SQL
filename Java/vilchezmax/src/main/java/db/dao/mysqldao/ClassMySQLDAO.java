package db.dao.mysqldao;

import db.dao.IBaseDAO;

import java.sql.ResultSet;
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
    public List<Class> getAll() throws SQLException {
        return null;
    }

    @Override
    public Class extractData(ResultSet result) throws SQLException {
        return null;
    }
}

