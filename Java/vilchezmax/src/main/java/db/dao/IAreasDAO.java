package db.dao;

import java.util.List;

public interface IAreasDAO<Area> extends IBaseDAO<Area> {
    List<Area> getAllByWorkerId(Integer id);
}
