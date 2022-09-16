package db.mysqldao;

import db.SolvdConnection;
import db.dao.IBaseDAO;
import db.models.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerMySQLDAO implements IBaseDAO<Worker> {

    public Worker extractWorkerData(ResultSet result) throws SQLException {
        Worker worker = new Worker();
        worker.setId(result.getInt(1));
        worker.setRole(result.getInt(2)); //TODO DATATYPE FIX: HOW TO GET OBJECT DATA FROM DAO AND NOT SERVICE?
        worker.setSeniority(result.getInt(3)); //TODO DATATYPE FIX
        worker.setFirstName(result.getString(4));
        worker.setLastName(result.getString(5));
        worker.setIdNumber(result.getInt(6));
        worker.setEmail(result.getString(7));
        worker.setWage(result.getInt(8));
        worker.setPhd(result.getBoolean(9));
        //experiments?
        //areas?
        return worker;
    }

    @Override
    public void create(Worker object) throws SQLException {
        Connection connection = new SolvdConnection().getConnection();
        String query = "INSERT INTO Workers VALUES(?,?,?,?,?,?,?,?,?)";
        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, object.getId());
            ps.setInt(2, object.getRole().getId());
            ps.setInt(3, object.getSeniority().getId());
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
    public List<Worker> getAll() throws SQLException {
        Connection connection = new SolvdConnection().getConnection();
        ResultSet result = null;
        String query = "SELECT * FROM Workers";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + e.getMessage());
        }

        List<Worker> workers = new ArrayList<>();
        if (!result.wasNull()) {
            while (result.next()) {
                workers.add(result.getInt(1), extractWorkerData(result));
            }
        }
        return workers;
    }

}

