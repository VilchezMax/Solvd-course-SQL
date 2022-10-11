package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Tool;

import java.sql.SQLException;
import java.util.List;

public class ToolDAO implements ICrudDAO<Tool> {

    @Override
    public void create(Tool object) throws SQLException {

    }

    @Override
    public Tool getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Tool object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Tool> getAll() throws SQLException {
        return null;
    }

}

