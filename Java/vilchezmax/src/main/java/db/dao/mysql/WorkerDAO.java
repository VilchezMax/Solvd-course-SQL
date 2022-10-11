package db.dao.mysql;

import db.dao.ICrudDAO;
import db.dao.IExtractData;
import db.jdbc.DBConnectionPool;
import db.models.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class WorkerDAO implements ICrudDAO<Worker>, IExtractData<Worker> {
    private static final Logger logger = LogManager.getLogger(WorkerDAO.class);

    @Override
    public void create(Worker object) {
        Connection connection = null;
        String query = "INSERT INTO Workers VALUES(?,?,?,?,?,?,?,?,?,?)";
        int result = 0;
        PreparedStatement ps = null;
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);

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
            logger.warn(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.warn(e.getMessage());
            }
        }
        logger.info(result + " rows updated.");
    }

    @Override
    public Worker getById(Integer id) {
        Worker worker = null;
        ResultSet result = null;
        String query = "SELECT * FROM Workers WHERE id = ?";
        try (Connection connection = DBConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            result = ps.executeQuery();
            worker = extractData(result.next() ? result : null); // if result is not null, extract data from it
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return worker;
    }

    @Override
    public void update(Worker object) {

        String query = "UPDATE Workers " +
                "SET role_id=?,seniority_id=?,first_name=?,last_name=?,id_number=?,birth_date=?,email=?,wage=?,phd=? " +
                "WHERE id = ?";
        int result = 0;
        try (Connection connection = DBConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

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

            result = ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }

        logger.info(result + " rows updated.");
    }

    @Override
    public void remove(Integer id) {

        String query = "DELETE FROM Workers WHERE id = ?";
        int result = 0;
        try (Connection connection = DBConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        logger.info(result + " rows updated.");
    }

    @Override
    public ArrayList<Worker> getAll() {

        ResultSet result = null;
        String query = "SELECT * FROM Workers";
        ArrayList<Worker> workers = null;

        try (Connection connection = DBConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            result = ps.executeQuery();

            if (!result.wasNull()) {
                while (result.next()) {
                    workers.add(result.getInt(1), extractData(result));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + e.getMessage());
        }
        return workers;
    }

    @Override
    public Worker extractData(ResultSet result) throws SQLException {
        Worker worker = new Worker();
        worker.setId(result.getInt(1));
        worker.setFirstName(result.getString(4));
        worker.setLastName(result.getString(5));
        worker.setIdNumber(result.getInt(6));
        worker.setBirthDate(result.getDate(7));
        worker.setEmail(result.getString(8));
        worker.setWage(result.getInt(9));
        worker.setPhd(result.getBoolean(10));

        logger.info(worker);
        return worker;
    }

}