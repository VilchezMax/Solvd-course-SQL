package db.models;

import db.SolvdConnection;
import db.dao.IWorkerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Experiment> experiments;
    private Map<Integer, Area> areas;

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

    public Map<Integer, Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Map<Integer, Experiment> experiments) {
        this.experiments = experiments;
    }

    public Map<Integer, Area> getAreas() {
        return areas;
    }

    public void setAreas(Map<Integer, Area> areas) {
        this.areas = areas;
    }

    public Worker extractWorkerData(ResultSet result) throws SQLException {
        Worker worker = new Worker();
        worker.setId(result.getInt(1));
        worker.setRoleId(result.getInt(2));
        worker.setSeniorityId(result.getInt(3));
        worker.setFirstName(result.getString(4));
        worker.setLastName(result.getString(5));
        worker.setIdNumber(result.getInt(6));
        worker.setEmail(result.getString(7));
        worker.setWage(result.getInt(8));
        worker.setPhd(result.getBoolean(9));

        return worker;
    }

    @Override
    public void create(Worker object) throws SQLException {
        Connection connection = new SolvdConnection().getConnection();
        String query = "INSERT INTO Workers VALUES(?,?,?,?,?,?,?,?,?)";
        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, object.getId());
            ps.setInt(2, object.getRoleId());
            ps.setInt(3, object.getSeniorityId());
            ps.setString(4, object.getFirstName());
            ps.setString(5, object.getLastName());
            ps.setInt(6, object.getIdNumber());
            ps.setString(7, object.getEmail());
            ps.setInt(8, object.getWage());
            ps.setBoolean(9, object.isPhd());


            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(result + " rows updated.");
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Connection connection = new SolvdConnection().getConnection();
        ResultSet result = null;
        String query = "SELECT * FROM Workers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return extractWorkerData(result);
    }

    @Override
    public void update(Worker object) throws SQLException {
        PreparedStatement ps;
        String query = "UPDATE Workers SET role_id=?,seniority_id=?,first_name=?,last_name=?,id_number=?,email=?,wage=?,phd=? WHERE id = ?";
        try (Connection connection = new SolvdConnection().getConnection()) {
            ps = connection.prepareStatement(query);

            ps.setInt(1, object.getRoleId());
            ps.setInt(2, object.getSeniorityId());
            ps.setString(3, object.getFirstName());
            ps.setString(4, object.getLastName());
            ps.setInt(5, object.getIdNumber());
            ps.setString(6, object.getEmail());
            ps.setInt(7, object.getWage());
            ps.setBoolean(8, object.isPhd());
            ps.setInt(9, object.getId());
        }
        int result = ps.executeUpdate();
        System.out.println(result + " rows updated.");
    }

    @Override
    public void remove(Integer id) {
        Connection connection = new SolvdConnection().getConnection();
        String query = "DELETE FROM Worker where id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Map<Integer, Worker> getAll() throws SQLException {
        Connection connection = new SolvdConnection().getConnection();
        ResultSet result = null;
        String query = "SELECT * FROM Workers";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + e.getMessage());
        }

        Map<Integer, Worker> workers = new HashMap<>();
        if (!result.wasNull()) {
            while (result.next()) {
                workers.put(result.getInt(1), extractWorkerData(result));
            }
        }
        return workers;
    }
}
