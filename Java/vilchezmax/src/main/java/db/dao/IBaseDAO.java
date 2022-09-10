package db.dao;

public interface IBaseDAO<T> {
    void create(T object);

    T getById(Integer id);

    void update(T object);

    void remove(Integer id);
}
