package db.dao.mysql;

import db.dao.ICrudDAO;
import db.jdbc.DBConnectionPool;
import db.models.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements ICrudDAO<Role> {
    private static final Logger logger = LogManager.getLogger(RoleDAO.class);

    @Override
    public void create(Role object) throws SQLException {
        Connection connection = null;
        String query = "INSERT INTO roles VALUES(?)";
        int result = 0;
        PreparedStatement ps = null;
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, object.getName());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Role getById(Integer id) throws SQLException {
        Role role = null;
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM roles WHERE id = ?";
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            result = ps.executeQuery();
            role.setId(id);
            role.setName(result.getString("name"));
        } catch (Exception e) {
            logger.warn(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return role;
    }

    @Override
    public void update(Role object) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE roles SET name = ? WHERE id = ?";
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, object.getName());
            ps.setInt(2, object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Integer id) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "DELETE FROM roles WHERE id = ?";

        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Role> getAll() throws SQLException {
        List<Role> roles = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet result = null;

        String query = "SELECT * FROM roles";
        try {
            connection = DBConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeQuery();

            while (result.next()) {
                Role role = new Role();
                role.setId(result.getInt("id"));
                role.setName(result.getString("name"));
                roles.add(role);
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return roles;
    }

}

