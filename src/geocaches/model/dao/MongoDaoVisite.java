package geocaches.model.dao;

import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

import java.util.List;

public class MongoDaoVisite extends MongoDao<VisiteEntity> implements VisiteDao {

private static MongoDaoVisite instance;

        public static MongoDaoVisite getInstance() {
            if (instance == null) {
                instance = new MongoDaoVisite();
            }
            return instance;
        }

        private MongoDaoVisite() {
            super(VisiteEntity.class);
        }






    @Override
    public VisiteEntity findById(String id) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("login")
                .contains(id);
        return query.first();
    }

    @Override
    public List<VisiteEntity> findByUser(UtilisateurEntity user) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("utilisateur._id")
                .equal(user.getId());
        return query.asList();
    }

    @Override
    public List<VisiteEntity> findByDate(String dateTime) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("datetime")
                .contains(dateTime);
        return query.asList();
    }

    @Override
    public List<VisiteEntity> findByCache(CacheEntity cache) {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class).
                field("cache._id").equal(cache.getId());
        return query.asList();
    }

    @Override
    public void deleteByUser(UtilisateurEntity user) {

        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("utilisateur._id")
                .equal(user.getId());
        datastore.delete(query);
    }

    @Override
    public void deleteByCache(CacheEntity cache) {

        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("utilisateur._id")
                .equal(cache.getId());
        datastore.delete(query);
    }

    @Override
    public void updateByUser(UtilisateurEntity user){
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<VisiteEntity> query = datastore.find(VisiteEntity.class)
                .field("utilisateur._id")
                .equal(user.getId());

        datastore.update(query, datastore.createUpdateOperations(VisiteEntity.class).set("utilisateur", user));
    }

    @Override
    public void updateByCache(CacheEntity cache){
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<CacheEntity> query = datastore.find(CacheEntity.class)
                .field("utilisateur._id")
                .equal(cache.getId());

        datastore.update(query, datastore.createUpdateOperations(CacheEntity.class).set("cache", cache));
    }
}