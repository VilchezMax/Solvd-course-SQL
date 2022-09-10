package db.models;

import db.MySQLDAO;
import db.dao.IAnalysisDAO;

public class Analysis extends MySQLDAO implements IAnalysisDAO {
    private Long id;
    private String title;
    private Long sample;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }
}
