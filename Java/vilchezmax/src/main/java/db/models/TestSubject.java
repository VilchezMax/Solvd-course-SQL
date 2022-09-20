package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "subject")
@XmlType(propOrder = {"id", "name", "clazz", "healthRisk"})
@XmlAccessorType(XmlAccessType.FIELD)
public class TestSubject {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "clazz")
    private Class clazz;
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
