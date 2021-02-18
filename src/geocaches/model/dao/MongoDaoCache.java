package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;

import java.util.Collection;
import java.util.List;

public class MongoDaoCache extends MongoDao<CacheEntity> implements CacheDao {

    private static MongoDaoCache instance;

    public static MongoDaoCache getInstance() {
        if(instance==null){
            instance = new MongoDaoCache();
        }
        return instance;
    }
    private MongoDaoCache(){
        super(CacheEntity.class);
    }

    @Override
    public Collection<CacheEntity> findAll() {
       return  null;

    }

    public CacheEntity findById(int idCache) {
        return  null;
    }

    public List<CacheEntity> findByUser(UtilisateurEntity user) {
        return  null;
    }

    @Override
    public List<CacheEntity> findByLocation(String location) {
        return  null;
    }


}
