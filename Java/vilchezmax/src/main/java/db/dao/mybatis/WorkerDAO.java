package db.dao.mybatis;

import db.dao.IWorkerDAO;
import db.models.Worker;
import mybatis.MySessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class WorkerDAO implements IWorkerDAO {
    final Logger LOGGER = LogManager.getLogger(WorkerDAO.class);

    @Override
    public void create(Worker worker) throws SQLException {
        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                IWorkerDAO workerDAO = session.getMapper(IWorkerDAO.class);
                workerDAO.create(worker);
                session.commit();
            } catch (SQLException e) {
                LOGGER.warn(e.getMessage());
                session.rollback();
            }
        }
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        Worker worker = null;
        SqlSessionFactory factory = MySessionFactory.getInstance().getFactory();

        try (SqlSession session = factory.openSession()) {
            try {
                IWorkerDAO workerDAO = session.getMapper(IWorkerDAO.class);
                worker = workerDAO.getById(id);
                session.commit();
            } catch (SQLException e) {
                LOGGER.warn(e.getMessage());
                session.rollback();
            }
        }
        return worker;
    }

    @Override
    public void update(Worker worker) throws SQLException {
        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                IWorkerDAO workerDAO = session.getMapper(IWorkerDAO.class);
                workerDAO.update(worker);
                session.commit();
            } catch (SQLException e) {
                LOGGER.warn(e.getMessage());
                session.rollback();
            }
        }
    }

    @Override
    public void remove(Integer id) throws SQLException {
        SqlSessionFactory factory = MySessionFactory.getInstance().getFactory();
        factory.getConfiguration().addMapper(IWorkerDAO.class);

        try (SqlSession session = factory.openSession()) {
            try {
                IWorkerDAO workerDAO = session.getMapper(IWorkerDAO.class);
                workerDAO.remove(id);
                session.commit();
            } catch (Exception e) {
                LOGGER.warn(e.getMessage());
                session.rollback();
            }
        }
    }

    @Override
    public List<Worker> getAll() throws SQLException {
        List<Worker> workers = null;
        SqlSessionFactory factory = MySessionFactory.getInstance().getFactory();
        factory.getConfiguration().addMapper(IWorkerDAO.class);

        try (SqlSession session = factory.openSession()) {
            try {
                IWorkerDAO workerDAO = session.getMapper(IWorkerDAO.class);
                workers = workerDAO.getAll();
                session.commit();
            } catch (SQLException e) {
                LOGGER.warn(e.getMessage());
                session.rollback();
            }
        }
        return workers;
    }
}
