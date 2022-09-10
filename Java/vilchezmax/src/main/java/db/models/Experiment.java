package db.models;

import db.MySQLDAO;
import db.dao.IExperimentDAO;

import javax.security.auth.Subject;

public class Experiment extends MySQLDAO implements IExperimentDAO {
    private Long id;
    private String name;
    private Long subjectId;
    private Long substrateId;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSubstrateId() {
        return substrateId;
    }

    public void setSubstrateId(Long substrateId) {
        this.substrateId = substrateId;
    }
}
