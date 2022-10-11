package db.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;

@JsonPropertyOrder({"id", "name"})
@XmlRootElement(name = "seniority")
@XmlType(propOrder = {"id", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Seniority {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "Seniority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
