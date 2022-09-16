package db.models;

import db.mysqldao.WorkerMySQLDAO;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"id", "role", "seniority", "firstName", "lastName", "idNumber", "email", "wage", "phd", "experiments", "areas"})
public class Worker extends WorkerMySQLDAO {

    private Integer id;
    private Role role;
    private Seniority seniority;
    private String firstName;
    private String lastName;
    private Integer idNumber;
    private String email;
    private Integer wage;
    private boolean phd;
    private List<Experiment> experiments;
    private List<Area> areas;

    public Integer getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    @XmlElement(name = "role")
    public void setRole(Role role) {
        this.role = role;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    @XmlElement(name = "seniority")
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

    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    @XmlElement(name = "idNumber")
    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWage() {
        return wage;
    }

    @XmlElement(name = "wage")
    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public boolean isPhd() {
        return phd;
    }

    @XmlElement(name = "phd")
    public void setPhd(boolean phd) {
        this.phd = phd;
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    @XmlElement(name = "experiments")
    public void setExperiments(List<Experiment> experiments) {
        this.experiments = experiments;
    }

    public List<Area> getAreas() {
        return areas;
    }

    @XmlElement(name = "areas")
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}
