package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;

@JsonPropertyOrder({"id", "name", "clazz", "healthRisk"})
@XmlRootElement(name = "subject")
@XmlType(propOrder = {"id", "name", "clazz", "healthRisk"})
@XmlAccessorType(XmlAccessType.FIELD)
public class TestSubject {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "name")
    private String name;
    @JsonProperty
    @XmlElement(name = "clazz")
    private Class clazz;
    @JsonProperty
    @XmlElement(name = "healthRisk")
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

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public HealthRisk getHealthRisk() {
        return healthRisk;
    }

    public void setHealthRisk(HealthRisk healthRisk) {
        this.healthRisk = healthRisk;
    }
}
