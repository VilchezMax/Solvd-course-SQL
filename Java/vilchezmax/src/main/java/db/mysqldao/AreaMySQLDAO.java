package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Area;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class AreaMySQLDAO implements IBaseDAO<Area> {
    @Override
    public void create(Area object) throws SQLException {

    }

    @Override
    public Area getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Area object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}
