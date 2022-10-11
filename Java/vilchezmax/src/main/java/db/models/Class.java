package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;

@JsonPropertyOrder({"id", "name", "kingdom"})
@XmlRootElement(name = "class")
@XmlType(propOrder = {"id", "name", "kingdom"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Class<T> {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "name")
    private String name;
    @JsonProperty
    @XmlElement(name = "kingdom")
    private Kingdom kingdom;

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

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdomId(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kingdom=" + kingdom.toString() +
                '}';
    }
}
