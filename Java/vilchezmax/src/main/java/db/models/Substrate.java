package db.models;

import db.MySQLDAO;
import db.dao.ISubstrateDAO;

public class Substrate  extends MySQLDAO implements ISubstrateDAO {
    private Long id;
    private String name;
    private Long healthRiskId;

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

    public Long getHealthRiskId() {
        return healthRiskId;
    }

    public void setHealthRiskId(Long healthRiskId) {
        this.healthRiskId = healthRiskId;
    }
}
