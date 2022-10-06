package db.dao.mysqldao;

import db.dao.IBaseDAO;
import db.jdbc.DBConnectionPool;
import db.models.Role;
import db.models.Seniority;
import db.models.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerMySQLDAO implements IBaseDAO<Worker> {

    @Override
    public void create(Worker object) throws SQLException {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO Workers VALUES(?,?,?,?,?,?,?,?,?,?)";
        int result = 0;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, object.getId());
            ps.setInt(2, object.getRole().getId());
            ps.setInt(3, object.getSeniority().getId());
            ps.setString(4, object.getFirstName());
            ps.setString(5, object.getLastName());
            ps.setInt(6, object.getIdNumber());
            ps.setDate(7, (Date) object.getBirthDate()); // alternative: new sql.Date(object.getBirthDate().getTime())
            ps.setString(8, object.getEmail());
            ps.setInt(9, object.getWage());
            ps.setBoolean(10, object.isPhd());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(result + " rows updated.");
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        ResultSet result = null;
        String query = "SELECT * FROM Workers WHERE id = ?";
        Worker worker = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            result = ps.executeQuery();
            worker = extractData(result.next() ? result : null); /* MSJ PARA MAXI: VER NOTA DE VOZ 23.30 EN WP*
        } catch (SQLException e) {
            System.out.println(e);
        }
        return worker;
    }

    @Override
    public void update(Worker object) throws SQLException {
        PreparedStatement ps;
        String query = "UPDATE Workers " +
                "SET role_id=?,seniority_id=?,first_name=?,last_name=?,id_number=?,birth_date=?,email=?,wage=?,phd=? " +
                "WHERE id = ?";

        try (Connection connection = DBConnectionPool.getInstance().getConnection()) {
            ps = connection.prepareStatement(query);

            ps.setInt(1, object.getRole().getId());
            ps.setInt(2, object.getSeniority().getId());
            ps.setString(3, object.getFirstName());
            ps.setString(4, object.getLastName());
            ps.setInt(5, object.getIdNumber());
            ps.setDate(6, (Date) object.getBirthDate());
            ps.setString(7, object.getEmail());
            ps.setInt(8, object.getWage());
            ps.setBoolean(9, object.isPhd());
            ps.setInt(10, object.getId());
        }
        int result = ps.executeUpdate();
        System.out.println(result + " rows updated.");
    }

    @Override
    public void remove(Integer id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM Workers WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Worker> getAll() throws SQLException {
        Connection connection = DBConnectionPool.getInstance().getConnection();
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
                workers.add(result.getInt(1), extractData(result));
            }
        }
        return workers;
    }

    @Override
    public Worker extractData(ResultSet result) throws SQLException {
        Worker worker = new Worker();
        worker.setId(result.getInt(1));
        worker.setRole((Role) result.getObject(2)); //TODO DATATYPE FIX: HOW TO GET OBJECT DATA FROM DAO AND NOT SERVICE?
        worker.setSeniority((Seniority) result.getObject(3)); //TODO DATATYPE FIX: CAST IS ONLY FOR COMPILING
        worker.setFirstName(result.getString(4));
        worker.setLastName(result.getString(5));
        worker.setIdNumber(result.getInt(6));
        worker.setEmail(result.getString(7));
        worker.setWage(result.getInt(8));
        worker.setPhd(result.getBoolean(9));
        //experiments?
        //areas?
        System.out.println(worker);
        return worker;
    }

}

