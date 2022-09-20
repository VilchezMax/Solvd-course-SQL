package db.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "area")
@XmlType(propOrder = {"id", "wing", "name", "description", "workers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Area {

    @XmlAttribute
    private Integer id;
    @XmlElement(name = "wing")
    private LabWing wing;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "description")
    private String description;
    @XmlElementWrapper(name = "workers")
    @XmlElementRefs({
            @XmlElementRef(name = "worker", type = Worker.class, required = true),
    })
    private List<Worker> workers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LabWing getWing() {
        return wing;
    }

    public void setWing(LabWing wing) {
        this.wing = wing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
