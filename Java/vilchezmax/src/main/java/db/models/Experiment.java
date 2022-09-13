package db.models;

import db.dao.IExperimentDAO;

public class Experiment extends MySQLDAO implements IExperimentDAO {
    private Integer id;
    private String name;
    private TestSubject subject;
    private Substrate substrate;

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

    public TestSubject getSubject() {
        return subject;
    }

    public void setSubject(TestSubject subject) {
        this.subject = subject;
    }

    public Substrate getSubstrate() {
        return substrate;
    }

    public void setSubstrate(Substrate substrate) {
        this.substrate = substrate;
    }
}
