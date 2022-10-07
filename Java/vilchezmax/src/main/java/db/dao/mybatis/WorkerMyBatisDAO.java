package db.dao.mybatis;

import db.dao.ICrudDAO;
import db.dao.mysql.WorkerMySQLDAO;
import db.models.Worker;
import mybatis.MySessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WorkerMyBatisDAO implements ICrudDAO<Worker> {
    final Logger LOGGER = LogManager.getLogger(WorkerMyBatisDAO.class);

    @Override
    public void create(Worker worker) throws SQLException {
        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                WorkerMyBatisDAO workerDAO = session.getMapper(WorkerMyBatisDAO.class);
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

        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                WorkerMyBatisDAO workerDAO = session.getMapper(WorkerMyBatisDAO.class);
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
                WorkerMyBatisDAO workerDAO = session.getMapper(WorkerMyBatisDAO.class);
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
        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                WorkerMyBatisDAO workerDAO = session.getMapper(WorkerMyBatisDAO.class);
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

        try (SqlSession session = MySessionFactory.getInstance().getFactory().openSession()) {
            try {
                WorkerMySQLDAO workerDAO = session.getMapper(WorkerMySQLDAO.class);
                workers = workerDAO.getAll();
                session.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                session.rollback();
            }
        }
        return workers;
    }
}
