package db.dao;

import java.util.ArrayList;


public interface IAreaDAO<Area> extends ICrudDAO<Area> {
    ArrayList<Area> getAllByWorkerId(Integer id);
}
