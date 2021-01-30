package geocaches.model.dao;

import geocaches.model.entities.UtilisateurEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public abstract class JpaDao<T> implements Dao<T> {
    protected static final SessionFactory sessionFactory;
    protected static Session session;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    @Override
    public T create(T obj) {
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        return obj;
    }
    @Override
    public void delete(T obj) {
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
    }
}
