package jdbc.dao;

public interface IBaseDAO<T> {
    void create(T object);
    T getById(Long id);
    void update(T object);
    void remove(Long id);
}
