package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface IExtractData<T> {
    T extractData(ResultSet result) throws SQLException;
}
