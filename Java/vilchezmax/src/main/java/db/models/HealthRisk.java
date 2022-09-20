package db.models;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "HealthRisk")
@XmlType(propOrder = {"id", "level"})
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthRisk {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "level")
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
