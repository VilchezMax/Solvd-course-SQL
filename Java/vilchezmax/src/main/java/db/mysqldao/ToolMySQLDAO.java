package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Tool;
import db.models.Worker;

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
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

