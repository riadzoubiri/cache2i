package geocaches.model.dao;

import geocaches.model.entities.VisiteEntity;
import org.hibernate.query.Query;

import java.util.Collection;

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

}