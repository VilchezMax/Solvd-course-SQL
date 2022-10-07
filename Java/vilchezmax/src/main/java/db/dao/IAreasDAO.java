package db.dao;

import java.util.List;

public interface IAreasDAO<Area> extends ICrudDAO<Area> {
    List<Area> getAllByWorkerId(Integer id);
}
