package db.models;

import db.dao.ISampleDAO;

public class Sample extends MySQLDAO implements ISampleDAO {
    private Integer id;
    private String name;
    private Tool tool;

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

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
