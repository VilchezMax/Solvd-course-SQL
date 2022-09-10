package db.models;

import db.MySQLDAO;
import db.dao.IAreaDAO;

public class Area extends MySQLDAO implements IAreaDAO {
    private Integer id;
    private Integer wingId;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWingId() {
        return wingId;
    }

    public void setWingId(Integer wingId) {
        this.wingId = wingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
