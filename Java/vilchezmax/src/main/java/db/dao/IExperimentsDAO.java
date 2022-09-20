package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface IExperimentsDAO<T> extends IBaseDAO<T> {
    List<T> getAllByWorkerId(Integer id) throws SQLException;
}
