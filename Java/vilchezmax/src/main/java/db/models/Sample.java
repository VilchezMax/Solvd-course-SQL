package db.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Sample")
@XmlType(propOrder = {"id", "name", "tool"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Sample {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "tool")
    private Tool tool;

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

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
