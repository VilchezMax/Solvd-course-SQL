package db.models;

import db.MySQLDAO;
import db.dao.IWorkerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Worker extends MySQLDAO implements IWorkerDAO {
    private Integer id;
    private Integer roleId;
    private Integer seniorityId;
    private String firstName;
    private String lastName;
    private Integer idNumber;
    private String email;
    private Integer wage;
    private boolean phd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSeniorityId() {
        return seniorityId;
    }

    public void setSeniorityId(Integer seniorityId) {
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

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
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

    @Override
    public void create(Worker object) throws SQLException {
        Connection con = con.createStatement().getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO Workers VALUES(?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, object.getId());
        ps.setInt(2, object.getRoleId());
        ps.setInt(3, object.getSeniorityId());
        ps.setString(4, object.getFirstName());
        ps.setString(5, object.getLastName());
        ps.setInt(6, object.getIdNumber());
        ps.setString(7, object.getEmail());
        ps.setInt(8, object.getWage());
        ps.setBoolean(9, object.isPhd());


        int result = ps.executeUpdate();
        System.out.println(result + " rows updated.");
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Connection con = con.createStatement().getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Workers WHERE id = ?");
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        return (Worker) result.getStatement();
    }

    @Override
    public void update(Worker object) throws SQLException {
        Connection con = con.createStatement().getConnection();
        PreparedStatement ps = con.prepareStatement
                ("UPDATE Workers SET role_id=?,seniority_id=?,first_name=?,last_name=?,id_number=?,email=?,wage=?,phd=? WHERE id = ?");
        ps.setInt(1, object.getRoleId());
        ps.setInt(2, object.getSeniorityId());
        ps.setString(3, object.getFirstName());
        ps.setString(4, object.getLastName());
        ps.setInt(5, object.getIdNumber());
        ps.setString(6, object.getEmail());
        ps.setInt(7, object.getWage());
        ps.setBoolean(8, object.isPhd());
        ps.setInt(9, object.getId());

        int result = ps.executeUpdate();
        System.out.println(result + " rows updated.");
    }

    @Override
    public void remove(Integer id) throws SQLException {
        Connection con = con.createStatement().getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM Worker where id = ?");
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        System.out.println(result + " rows updated.");
    }
}
