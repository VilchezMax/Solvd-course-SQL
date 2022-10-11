package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.HealthRisk;

import java.sql.SQLException;
import java.util.List;

public class HealthRiskDAO implements ICrudDAO<HealthRisk> {

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
}

