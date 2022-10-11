package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;
import java.util.List;

@JsonPropertyOrder({"id", "wing", "name", "description", "workers"})
@XmlRootElement(name = "area")
@XmlType(propOrder = {"id", "wing", "name", "description", "workers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Area {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "wing")
    private LabWing wing;
    @JsonProperty
    @XmlElement(name = "name")
    private String name;
    @JsonProperty
    @XmlElement(name = "description")
    private String description;
    @JsonProperty
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

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", wing=" + wing.toString() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", workers=" + workers.toString() +
                '}';
    }
}
