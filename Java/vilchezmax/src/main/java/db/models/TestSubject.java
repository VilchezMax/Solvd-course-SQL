package db.models;

import db.MySQLDAO;
import db.dao.ITestSubjectDAO;

public class TestSubject extends MySQLDAO implements ITestSubjectDAO {
    private Integer id;
    private String name;
    private Integer classId;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getHealthRiskId() {
        return healthRiskId;
    }

    public void setHealthRiskId(Integer healthRiskId) {
        this.healthRiskId = healthRiskId;
    }
}
