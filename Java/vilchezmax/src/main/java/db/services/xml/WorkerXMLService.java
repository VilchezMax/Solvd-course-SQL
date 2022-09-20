package db.services.xml;

import db.models.Worker;
import db.services.ICRUDServices;

import java.sql.SQLException;
import java.util.List;

public class WorkerXMLService implements ICRUDServices<Worker> {
    @Override
    public void create(Worker worker) throws SQLException {
        
    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void update(Worker worker) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<Worker> getAll() {
        return null;
    }
}
