package db.models;

import db.mysqldao.AnalysisMySQLDAO;

import java.util.Map;

public class Analysis extends AnalysisMySQLDAO {
    private Integer id;
    private String title;
    private Sample sample;
    private Map<Integer, Experiment> experiments;


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

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Map<Integer, Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Map<Integer, Experiment> experiments) {
        this.experiments = experiments;
    }
}
