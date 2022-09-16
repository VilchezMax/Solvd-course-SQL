package db.mysqldao;

import db.dao.IBaseDAO;
import db.models.TestSubject;
import db.models.Worker;

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
    public List<Worker> getAll() throws SQLException {
        return null;
    }
}

