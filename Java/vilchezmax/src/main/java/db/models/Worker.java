package db.models;

import db.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "worker")
@XmlType(propOrder = {"id", "role", "seniority", "firstName", "lastName", "idNumber", "birthDate", "email", "wage", "phd", "experiments", "areas"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "role")
    private Role role;
    @XmlElement(name = "seniority")
    private Seniority seniority;
    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "idNumber")
    private Integer idNumber;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "birthDate")
    private Date birthDate;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "wage")
    private Integer wage;
    @XmlElement(name = "phd")
    private boolean phd;
    @XmlElementWrapper(name = "experiments")
    @XmlElementRefs({
            @XmlElementRef(name = "experiment", type = Experiment.class, required = true),
    })
    private List<Experiment> experiments;
    @XmlElementWrapper(name = "areas")
    @XmlElementRefs({
            @XmlElementRef(name = "area", type = Area.class, required = true),
    })
    private List<Area> areas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Seniority getSeniority() {
        return seniority;
    }


    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public boolean isPhd() {
        return phd;
    }

    public void setPhd(boolean phd) {
        this.phd = phd;
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) {
        this.experiments = experiments;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}
