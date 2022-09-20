package db.dao.mysqldao;

import db.dao.IAreasDAO;
import db.models.Area;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AreaMySQLDAO implements IAreasDAO<Area> {
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
    public List<Area> getAll() throws SQLException {
        return null;
    }

    @Override
    public Area extractData(ResultSet result) throws SQLException {
        return null;
    }

    @Override
    public List<Area> getAllByWorkerId(Integer id) {
        return null;
    }
}
