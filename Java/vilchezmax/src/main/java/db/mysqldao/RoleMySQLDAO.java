package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleMySQLDAO implements IBaseDAO<Role> {

    @Override
    public void create(Role object) throws SQLException {

    }

    @Override
    public Role getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Role object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Role> getAll() throws SQLException {
        return null;
    }
}

