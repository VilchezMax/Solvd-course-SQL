package db.dao.mysqldao;

import db.dao.IBaseDAO;
import db.models.TestSubject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestSubjectMySQLDAO implements IBaseDAO<TestSubject> {

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

    @Override
    public TestSubject extractData(ResultSet result) throws SQLException {
        return null;
    }
}

