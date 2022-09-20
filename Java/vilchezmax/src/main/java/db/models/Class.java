package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Class")
@XmlType(propOrder = {"id", "name", "kingdom"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Class {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "name")
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
}
