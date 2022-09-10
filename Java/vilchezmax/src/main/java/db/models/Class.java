package db.models;

import db.MySQLDAO;
import db.dao.IClassDAO;

public class Class extends MySQLDAO implements IClassDAO {
    private Long id;
    private String name;
    private Long kingdomId;

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

    public Long getKingdomId() {
        return kingdomId;
    }

    public void setKingdomId(Long kingdomId) {
        this.kingdomId = kingdomId;
    }
}
