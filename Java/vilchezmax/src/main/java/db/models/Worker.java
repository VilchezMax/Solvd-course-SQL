package db.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import db.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@JsonPropertyOrder({"id", "role", "seniority", "firstName", "lastName", "idNumber", "birthDate", "email", "wage", "phd", "experiments", "areas"})
@XmlRootElement(name = "worker")
@XmlType(propOrder = {"id", "role", "seniority", "firstName", "lastName", "idNumber", "birthDate", "email", "wage", "phd", "experiments", "areas"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    @JsonProperty
    @XmlAttribute
    private Integer id;
    @JsonProperty
    @XmlElement(name = "role")
    private Role role;
    @JsonProperty
    @XmlElement(name = "seniority")
    private Seniority seniority;
    @JsonProperty
    @XmlElement(name = "firstName")
    private String firstName;
    @JsonProperty
    @XmlElement(name = "lastName")
    private String lastName;
    @JsonProperty
    @XmlElement(name = "idNumber")
    private Integer idNumber;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "birthDate")
    private Date birthDate;
    @JsonProperty
    @XmlElement(name = "email")
    private String email;
    @JsonProperty
    @XmlElement(name = "wage")
    private Integer wage;
    @JsonProperty
    @XmlElement(name = "phd")
    private boolean phd;
    @JsonProperty
    @XmlElementWrapper(name = "experiments")
    @XmlElementRefs({
            @XmlElementRef(name = "experiment", type = Experiment.class, required = true),
    })
    private List<Experiment> experiments;
    @JsonProperty
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

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", role=" + role +
                ", seniority=" + seniority +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber=" + idNumber +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", wage=" + wage +
                ", phd=" + phd +
                ", experiments=" + experiments +
                ", areas=" + areas +
                '}';
    }
}
