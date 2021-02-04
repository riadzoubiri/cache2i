package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.VisiteEntity;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

public class JpaDaoVisite extends JpaDao<VisiteEntity> implements VisiteDao {
    private static JpaDaoVisite instance;

    public static JpaDaoVisite getInstance() {
        if (instance == null) {
            instance = new JpaDaoVisite();
        }
        return instance;
    }

    private JpaDaoVisite() {
    }

    @Override
    public Collection<VisiteEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM VisiteEntity a");
        return query.getResultList();
    }

    @Override
    public VisiteEntity findById(int id) {
        Query query = session.createQuery("SELECT a FROM VisiteEntity a where id=:id");
        query.setParameter("id",id);
        return (VisiteEntity) query.getSingleResult();
    }


    @Override
    public List<VisiteEntity> findByUser(String userLogin) {
        Query query= session.createQuery("select a from VisiteEntity a where utilisateur=:userLogin");
        query.setParameter("userLogin",userLogin);
        return (List<VisiteEntity>) query.getResultList();
    }

    @Override
    public List<VisiteEntity> findByDate(String dateTime) {
        Query query= session.createQuery("select a from VisiteEntity a where date=:dateTime");
        query.setParameter("dateTime",dateTime);
        return (List<VisiteEntity>) query.getResultList();
    }
}