package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "kingdom")
@XmlType(propOrder = {"id", "name"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Kingdom {
    @XmlAttribute
    private Integer id;
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
}
