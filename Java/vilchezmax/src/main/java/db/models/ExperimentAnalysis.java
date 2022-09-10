package db.models;

import db.MySQLDAO;
import db.dao.IExperimentAnalysisDAO;

public class ExperimentAnalysis extends MySQLDAO implements IExperimentAnalysisDAO {
    private Long id;
    private Long experimentId;
    private Long analysisId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Long getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Long analysisId) {
        this.analysisId = analysisId;
    }
}
