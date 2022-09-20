package db.dao.mysqldao;

import db.dao.IBaseDAO;
import db.models.Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ToolMySQLDAO implements IBaseDAO<Tool> {

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

    @Override
    public Tool extractData(ResultSet result) throws SQLException {
        return null;
    }
}

