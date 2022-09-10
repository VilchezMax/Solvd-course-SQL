package db.models;

import db.MySQLDAO;
import db.dao.IExperimentAnalysisDAO;

public class ExperimentAnalysis extends MySQLDAO implements IExperimentAnalysisDAO {
    private Long id;
    private Experiment experiment;
    private Analysis analysis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }
}
