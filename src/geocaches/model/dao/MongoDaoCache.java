package geocaches.model.dao;

import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
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
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class);
        return query.asList();
    }

    public CacheEntity findById(String idCache) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class)
                .field("login")
                .contains(idCache);
        return query.first();
    }

    public List<CacheEntity> findByUser(UtilisateurEntity user) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class)
                .field("utilisateur._id")
                .equal(user.getId());
        return query.asList();
    }

    @Override
    public List<CacheEntity> findByLocation(String location) {

        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class)
                .field("gps")
                .contains(location);
        return query.asList();
    }

    @Override
    public void deleteByUser(UtilisateurEntity user) {

        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class)
                .field("utilisateur._id")
                .equal(user.getId());
        datastore.delete(query);
    }


}
