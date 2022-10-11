package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface IExperimentDAO<T> extends ICrudDAO<T> {
    List<T> getAllByWorkerId(Integer id) throws SQLException;
}
