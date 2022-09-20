package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    void create(T object) throws SQLException;

    T getById(Integer id) throws SQLException;

    void update(T object) throws SQLException;

    void remove(Integer id) throws SQLException;

    List<T> getAll() throws SQLException;

    T extractData(ResultSet result) throws SQLException;
}
