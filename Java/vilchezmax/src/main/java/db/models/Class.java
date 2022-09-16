package db.models;

import db.mysqldao.ClassMySQLDAO;

public class Class extends ClassMySQLDAO {
    private Integer id;
    private String name;
    private Kingdom kingdom;

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

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdomId(Kingdom kingdom) {
        this.kingdom = kingdom;
    }
}
