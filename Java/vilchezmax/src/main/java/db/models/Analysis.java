package db.models;

import db.MySQLDAO;
import db.dao.IAnalysisDAO;

public class Analysis extends MySQLDAO implements IAnalysisDAO {
    private Long id;
    private String title;
    private Long sampleId;

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

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }
}
