package db.models;

import db.MySQLDAO;
import db.dao.IHealthRiskDAO;

public class HealthRisk  extends MySQLDAO implements IHealthRiskDAO {
    private Long id;
    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
