package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.Analysis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AnalysisMySQLDAO implements ICrudDAO<Analysis> {


    @Override
    public void create(Analysis object) throws SQLException {

    }

    @Override
    public Analysis getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Analysis object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<Analysis> getAll() {
        return null;
    }

    @Override
    public Analysis extractData(ResultSet result) throws SQLException {
        return null;
    }
}

