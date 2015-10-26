
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
@Service("genericDaoImpl")
public class GenericDaoImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    public T read(int id) {
        return this.entityManager.find(entityClass, id);
    }

    public T update(T t) {
        return this.entityManager.merge(t);
    }

    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    public void save(T t) {
        entityManager.persist(t);
    }
}