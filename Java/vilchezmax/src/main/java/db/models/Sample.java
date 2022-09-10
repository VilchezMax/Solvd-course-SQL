package db.models;

import db.MySQLDAO;
import db.dao.ISampleDAO;

public class Sample extends MySQLDAO implements ISampleDAO {
    private Integer id;
    private String name;
    private Integer toolId;

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

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }
}
