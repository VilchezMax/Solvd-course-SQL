package db.dao.mysql;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    void create(T object) throws SQLException;

    T getById(Integer id) throws SQLException;

    void update(T object) throws SQLException;

    void remove(Integer id) throws SQLException;
}
