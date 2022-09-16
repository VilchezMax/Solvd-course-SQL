package db.models;

import db.mysqldao.LabWingMySQLDAO;

public class LabWing extends LabWingMySQLDAO {
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
