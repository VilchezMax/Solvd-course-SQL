package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;

@JsonPropertyOrder({"id", "name", "healthRisk"})
@XmlRootElement(name = "substrate")
@XmlType(propOrder = {"id", "name", "healthRisk"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Substrate {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "name")
    private String name;
    @JsonProperty
    @XmlElement(name = "healthrisk")
    private HealthRisk healthRisk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HealthRisk getHealthRisk() {
        return healthRisk;
    }

    public void setHealthRisk(HealthRisk healthRisk) {
        this.healthRisk = healthRisk;
    }
}
