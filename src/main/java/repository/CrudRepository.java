package repository;

import java.util.List;

public interface CrudRepository<T> extends SuperDao{
    boolean save(T t);
    boolean delete(String id);
    List<T> getAll();
    boolean update(T t);
    T search(String id);
}
