package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Substrate;

import java.sql.SQLException;
import java.util.List;

public class SubstrateMySQLDAO implements IBaseDAO<Substrate> {

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
}

