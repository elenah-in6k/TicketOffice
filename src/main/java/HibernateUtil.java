import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.*;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final StandardServiceRegistryBuilder serviceRegistry;

    static {
        Configuration conf = new Configuration();
        conf.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                conf.getProperties());
        try {
            sessionFactory = conf.buildSessionFactory(serviceRegistry.build());
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

