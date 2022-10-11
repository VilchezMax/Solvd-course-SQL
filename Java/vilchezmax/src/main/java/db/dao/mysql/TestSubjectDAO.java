package db.dao.mysql;

import db.dao.ICrudDAO;
import db.models.TestSubject;

import java.sql.SQLException;
import java.util.List;

public class TestSubjectDAO implements ICrudDAO<TestSubject> {

    @Override
    public void create(TestSubject object) throws SQLException {

    }

    @Override
    public TestSubject getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(TestSubject object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public List<TestSubject> getAll() throws SQLException {
        return null;
    }

}

