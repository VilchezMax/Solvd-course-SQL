package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;
import java.util.List;

@JsonPropertyOrder({"id", "title", "sample", "experiments"})
@XmlRootElement(name = "analysis")
@XmlType(propOrder = {"id", "title", "sample", "experiments"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Analysis {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "title")
    private String title;
    @JsonProperty
    @XmlElement(name = "sample")
    private Sample sample;
    @JsonProperty
    @XmlElementWrapper(name = "experiments")
    @XmlElementRefs({
            @XmlElementRef(name = "experiment", type = Experiment.class, required = true),
    })
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
