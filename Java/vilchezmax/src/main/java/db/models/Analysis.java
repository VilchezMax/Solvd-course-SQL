package db.models;

import db.MySQLDAO;
import db.dao.IAnalysisDAO;

public class Analysis extends MySQLDAO implements IAnalysisDAO {
    private Integer id;
    private String title;
    private Integer sampleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }
}
