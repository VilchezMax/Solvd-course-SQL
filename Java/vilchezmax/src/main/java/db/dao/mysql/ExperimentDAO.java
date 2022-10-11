package db.dao.mysql;

import db.dao.IExperimentDAO;
import db.dao.IExtractData;
import db.jdbc.DBConnectionPool;
import db.models.Experiment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExperimentDAO implements IExperimentDAO<Experiment>, IExtractData<Experiment> {

    final Logger logger = LogManager.getLogger(ExperimentDAO.class);

    @Override
    public void create(Experiment object) throws SQLException {

    }

    @Override
    public Experiment getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Experiment object) throws SQLException {

    }

    @Override
    public void remove(Integer id) throws SQLException {

    }

    @Override
    public ArrayList<Experiment> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Experiment> getAllByWorkerId(Integer id) throws SQLException {

        ResultSet result = null;
        String query = "SELECT * FROM Workers";

        try (Connection connection = DBConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            result = ps.executeQuery();
        } catch (SQLException e) {
            logger.warn(e.getSQLState() + e.getMessage());
        }

        ArrayList<Experiment> experiments = new ArrayList<>();
        if (!result.wasNull()) {
            while (result.next()) {
                experiments.add(extractData(result));
                //LACKING SUBJECT AND SUBSTRATE OBJECTS
            }
        }
        return experiments;
    }

    @Override
    public Experiment extractData(ResultSet result) throws SQLException {
        Experiment experiment = new Experiment();
        experiment.setId(result.getInt(1));
        experiment.setName(result.getString(2));
        //experiment.setSubject(result.get);
        //experiment.setSubstrate(result.get);
        return experiment;
    }

}

