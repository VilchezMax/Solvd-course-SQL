package db.models;

import db.MySQLDAO;
import db.dao.IExperimentDAO;

import javax.security.auth.Subject;

public class Experiment extends MySQLDAO implements IExperimentDAO {
    private Long id;
    private String name;
    private Subject subject;
    private Substrate substrate;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Substrate getSubstrate() {
        return substrate;
    }

    public void setSubstrate(Substrate substrate) {
        this.substrate = substrate;
    }
}
