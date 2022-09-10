package db.models;

import db.MySQLDAO;
import db.dao.IWorkerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Worker extends MySQLDAO implements IWorkerDAO {
    private Long id;
    private Role role;
    private Seniority seniority;
    private String firstName;
    private String lastName;
    private Long idNumber;
    private String email;
    private Long wage;
    private boolean phd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public boolean isPhd() {
        return phd;
    }

    public void setPhd(boolean phd) {
        this.phd = phd;
    }

    @Override
    public void create(Worker object) {
        //Connection x = x.getConnection();
        //PreparedStatement ps = x.prepareStatement("INSERT INTO Worker VALUES(?,?,?,?,?,?,?)");
        //ps.setInt(1,object.id);
        //ps.setInt(2,object.role.id);
        //ps.setInt(3,object.seniority.id);
        //ps.setString(4,object);
        //ps.setString(5,);
        //ps.setInt(6,object.idNumber);

        //ResultSet result = ps.executeQuery();
    }

    @Override
    public Worker getById(Long id) {
        //Connection x = x.getConnection();
        //PreparedStatement ps = x.prepareStatement("SELECT * FROM Worker where id = ?");
        //ps.setInt(1,id);
        //ResultSet result = ps.executeQuery();
        return null;
    }

    @Override
    public void update(Worker object) {

    }

    @Override
    public void remove(Long id) {

    }
}
