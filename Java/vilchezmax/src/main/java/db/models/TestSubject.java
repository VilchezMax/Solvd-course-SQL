package db.models;

import db.MySQLDAO;
import db.dao.ITestSubjectDAO;

public class TestSubject  extends MySQLDAO implements ITestSubjectDAO {
    private Long id;
    private String name;
    private Long classId;
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getHealthRiskId() {
        return healthRiskId;
    }

    public void setHealthRiskId(Long healthRiskId) {
        this.healthRiskId = healthRiskId;
    }
}
