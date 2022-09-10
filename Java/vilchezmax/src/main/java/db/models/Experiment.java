package db.models;

import db.MySQLDAO;
import db.dao.IExperimentDAO;

public class Experiment extends MySQLDAO implements IExperimentDAO {
    private Integer id;
    private String name;
    private Integer subjectId;
    private Integer substrateId;

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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubstrateId() {
        return substrateId;
    }

    public void setSubstrateId(Integer substrateId) {
        this.substrateId = substrateId;
    }
}
