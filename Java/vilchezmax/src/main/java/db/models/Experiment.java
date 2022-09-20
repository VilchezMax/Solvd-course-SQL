package db.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "experiment")
@XmlType(propOrder = {"id", "name", "subject", "substrate", "analyses", "workers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Experiment {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "subject")
    private TestSubject subject;
    @XmlElement(name = "substrate")
    private Substrate substrate;
    @XmlElementWrapper(name = "analyses")
    @XmlElementRefs({
            @XmlElementRef(name = "analysis", type = Analysis.class, required = true),
    })
    private List<Analysis> analyses;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestSubject getSubject() {
        return subject;
    }

    public void setSubject(TestSubject subject) {
        this.subject = subject;
    }

    public Substrate getSubstrate() {
        return substrate;
    }

    public void setSubstrate(Substrate substrate) {
        this.substrate = substrate;
    }

    public List<Analysis> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analysis> analyses) {
        this.analyses = analyses;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
