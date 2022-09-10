package db.models;

import db.MySQLDAO;
import db.dao.ISampleDAO;

public class Sample  extends MySQLDAO implements ISampleDAO {
    private Long id;
    private String name;
    private Tool tool;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
