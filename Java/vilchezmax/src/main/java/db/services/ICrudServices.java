package db.services;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDServices<T> {
    void create(T t) throws SQLException;

    T getById(Integer id) throws SQLException;

    void update(T t);

    void remove(Integer id);

    List<T> getAll();

}
