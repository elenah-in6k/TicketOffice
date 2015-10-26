import java.io.Serializable;

/**
 * Created by Алена on 25.10.2015.
 */
public interface GenericDao<T, PK extends Serializable> {
    T create(T t);
    T read(int id);
    T update(T t);
    void delete(T t);
    void save(T t);
}
