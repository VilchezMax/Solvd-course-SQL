package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.Analysis;
import db.models.Worker;

import java.sql.SQLException;
import java.util.List;

public class AnalysisMySQLDAO implements IBaseDAO<Analysis> {


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
    public List<Worker> getAll() {
        return null;
    }
}

