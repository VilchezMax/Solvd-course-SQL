package db.models;

import db.MySQLDAO;
import db.dao.ISeniorityDAO;

public class Seniority extends MySQLDAO implements ISeniorityDAO {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
