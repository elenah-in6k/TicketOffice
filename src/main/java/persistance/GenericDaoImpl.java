package persistance;

import core.dao.GenericDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class GenericDaoImpl<T>
        implements GenericDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    public Class<T> entityClass;

    public GenericDaoImpl() {
        Class<T> clazz;
        try {
            clazz = getClassType();
        } catch (Exception e) {
            clazz = null;
        }
        this.entityClass = clazz;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClassType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T create(T t) {
        getSession().persist(t);
        return t;
    }

    public T read(int id) {
        return getSession().get(entityClass, id);
    }

    public void update(T t) {
       getSession().update(t);
    }


    public void delete(T t) {

        getSession().delete(t);
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void save(T t) {
        getSession().persist(t);
    }

    protected Query createQuery(String q) {
        Query query = getSession().createQuery(q);
        return query;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll(){
        return getSession().createCriteria(entityClass).list();
    }
}