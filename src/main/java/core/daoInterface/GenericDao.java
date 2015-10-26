package core.daoInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Алена on 25.10.2015.
 */
public interface GenericDao<T, PK extends Serializable> {
    T create(T t);
    List<T> read(int id, String nameField);
    void update(T t);
    void delete(T t);
    void save(T t);
}
