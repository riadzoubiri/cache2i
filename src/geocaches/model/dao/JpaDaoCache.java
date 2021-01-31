package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaDaoCache extends JpaDao<CacheEntity> implements CacheDao {
    private static JpaDaoCache instance;

    public static JpaDaoCache getInstance() {
        if(instance==null){
            instance = new JpaDaoCache();
        }
        return instance;
    }
    private JpaDaoCache(){
    }

    @Override
    public Collection<CacheEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM CacheEntity a");
        return query.getResultList();

    }

    public CacheEntity findById(int idCache) {
        Query query= session.createQuery("select a from CacheEntity a where a.id='"+idCache +"'");
        return (CacheEntity) query.getSingleResult();
    }
}
