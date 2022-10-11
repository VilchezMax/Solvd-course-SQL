package db.dao.mysql;

import db.dao.IAreaDAO;
import db.dao.IExtractData;
import db.models.Area;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDAO implements IAreaDAO<Area>, IExtractData<Area> {
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
    public ArrayList<Area> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Area> getAllByWorkerId(Integer id) {
        return null;
    }

    @Override
    public Area extractData(ResultSet result) throws SQLException {
        return null;
    }
}
