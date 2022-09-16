package db.models;

import db.mysqldao.AreaMySQLDAO;

public class Area extends AreaMySQLDAO {
    private Integer id;
    private LabWing wing;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LabWing getWing() {
        return wing;
    }

    public void setWing(LabWing wing) {
        this.wing = wing;
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
