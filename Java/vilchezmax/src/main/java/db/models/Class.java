package db.models;

import db.MySQLDAO;
import db.dao.IClassDAO;

public class Class extends MySQLDAO implements IClassDAO {
    private Integer id;
    private String name;
    private Integer kingdomId;

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

    public Integer getKingdomId() {
        return kingdomId;
    }

    public void setKingdomId(Integer kingdomId) {
        this.kingdomId = kingdomId;
    }
}
