package db.services;

import java.sql.SQLException;
import java.util.List;

public interface ICrudServices<T> {
    void create(T t) throws SQLException;

    T getById(Integer id) throws SQLException;

    void update(T t) throws SQLException;

    void remove(Integer id) throws SQLException;

    List<T> getAll();

}
