package db.dao.mysqldao;

import db.dao.IBaseDAO;
import db.models.HealthRisk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HealthRiskMySQLDAO implements IBaseDAO<HealthRisk> {

    @Override
    public void create(HealthRisk object) throws SQLException {

    }

    @Override
    public HealthRisk getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(HealthRisk object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<HealthRisk> getAll() throws SQLException {
        return null;
    }

    @Override
    public HealthRisk extractData(ResultSet result) throws SQLException {
        return null;
    }
}

