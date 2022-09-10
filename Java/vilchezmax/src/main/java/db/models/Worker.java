package db.models;

import db.MySQLDAO;
import db.dao.IWorkerDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Worker extends MySQLDAO implements IWorkerDAO {
    private Long id;
    private Long roleId;
    private Long seniorityId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getSeniorityId() {
        return seniorityId;
    }

    public void setSeniorityId(Long seniorityId) {
        this.seniorityId = seniorityId;
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
    public void create(Worker object) throws SQLException {
        //Connection x = x.getConnection();
        PreparedStatement ps = x.prepareStatement("INSERT INTO Worker VALUES(?,?,?,?,?,?,?)");
        ps.setLong(1, object.getId());
        ps.setLong(2, object.getRoleId());
        ps.setLong(3, object.getSeniorityId());
        ps.setString(4, object.getFirstName());
        ps.setString(5, object.getLastName());
        ps.setLong(6, object.getIdNumber());
        ps.setString(7, object.getEmail());
        ps.setLong(8, object.getWage());
        ps.setBoolean(9, object.isPhd());


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
