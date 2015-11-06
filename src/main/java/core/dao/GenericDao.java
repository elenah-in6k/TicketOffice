package core.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Алена on 25.10.2015.
 */
@Repository
public interface GenericDao<T> {
    T create(T t);
    T read(int id);
    void update(T t);
    void delete(T t);
    void save(T t);
    List<T> getAll();
}
