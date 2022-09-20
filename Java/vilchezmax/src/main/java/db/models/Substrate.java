package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Substrate")
@XmlType(propOrder = {"id", "name", "healthRisk"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Substrate {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
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

    public HealthRisk getHealthRisk() {
        return healthRisk;
    }

    public void setHealthRisk(HealthRisk healthRisk) {
        this.healthRisk = healthRisk;
    }
}
