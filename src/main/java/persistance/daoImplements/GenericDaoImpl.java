package persistance.daoImplements;

import core.daoInterface.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service("genericDaoImpl")
@Transactional
public abstract class GenericDaoImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    @Autowired
    protected SessionFactory sessionFactory;
    public final Class<T> entityClass;


    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T t) {
        sessionFactory.getCurrentSession().persist(t);
        return t;
    }

    public List<T> read(int id, String nameField) {
        return this.sessionFactory.getCurrentSession().createQuery(String.format("from %s where %s = %s ", entityClass.getName().substring(12), nameField, "" + id)).list();
        //;
    }

    public void update(T t) {
       this.sessionFactory.getCurrentSession().update(t);
    }

    public void delete(T t) {
        this.sessionFactory.getCurrentSession().merge(t);
        this.sessionFactory.getCurrentSession().delete(t);
    }

    public void save(T t) {
        sessionFactory.getCurrentSession().persist(t);
    }
}