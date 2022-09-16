package db.models;


import db.mysqldao.HealthRiskMySQLDAO;

public class HealthRisk extends HealthRiskMySQLDAO {
    private Integer id;
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
