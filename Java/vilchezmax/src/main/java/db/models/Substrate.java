package db.models;

import db.MySQLDAO;
import db.dao.ISubstrateDAO;

public class Substrate extends MySQLDAO implements ISubstrateDAO {
    private Integer id;
    private String name;
    private Integer healthRiskId;

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

    public Integer getHealthRiskId() {
        return healthRiskId;
    }

    public void setHealthRiskId(Integer healthRiskId) {
        this.healthRiskId = healthRiskId;
    }
}
