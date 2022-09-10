package db.models;

import db.MySQLDAO;
import db.dao.IExperimentAnalysisDAO;

public class ExperimentAnalysis extends MySQLDAO implements IExperimentAnalysisDAO {
    private Integer id;
    private Integer experimentId;
    private Integer analysisId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
    }
}
