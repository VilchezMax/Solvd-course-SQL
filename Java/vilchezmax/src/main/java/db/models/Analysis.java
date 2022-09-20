package db.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Analysis")
@XmlType(propOrder = {"id", "title", "sample", "experiments"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Analysis {
    @XmlID
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "sample")
    private Sample sample;
    @XmlIDREF
    @XmlElement(name = "experiment")
    private List<Experiment> experiments;


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

    public List<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) {
        this.experiments = experiments;
    }
}
