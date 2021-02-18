package geocaches.model.dao;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.mapping.DefaultCreator;
import dev.morphia.mapping.MapperOptions;
import geocaches.model.entities.UtilisateurEntity;

import java.util.Collection;

public abstract class MongoDao<T> implements Dao<T> {

    protected MongoClient mongoClient;
    protected MongoDatabase database;
    protected Class<T> classEntity;


    public MongoDao(Class<T> entity) {
        this.classEntity = entity;
        this.openSession();
    }

    public void openSession() {
        mongoClient = new MongoClient("localhost",27017);
        database = mongoClient.getDatabase("geocache");
        database.getCollection("UtilisateurEntity");


 }

    public void closeSession() {
        mongoClient.close();
    }

    public T create(T entity) {
        try {
            Morphia morphia=new Morphia();
            morphia.mapPackage("geocaches.model.entities");
            Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
            System.out.println(datastore.toString());
            datastore.save(entity);
            return entity;
        } catch (Exception E) {
            System.out.println(E.toString());
            return null;
        }
    }

    public boolean update(T entity) {
        try {
           if(create(entity)!=null) return true;
           return false;
        } catch (Exception E) {
            System.out.println(E.toString());
            return false;
        }
    }

    public void delete(T entity) {
            Morphia morphia = new Morphia();
            morphia.map(entity.getClass());
            Datastore datastore = morphia.createDatastore(mongoClient,"geocache");
            datastore.delete(entity);
    }

    public T find(String id) {
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongoClient,"geocache");
        return datastore.get(classEntity, id);
    }

    public Collection<T> findAll() {
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongoClient,"geocache");
        return datastore.find(classEntity).asList();
    }

    public boolean deleteAll() {
        try {
            Morphia morphia = new Morphia();
            Datastore datastore = morphia.createDatastore(mongoClient,"geocache");
            datastore.delete(datastore.createQuery(classEntity));
            return true;
        } catch (Exception E) {
            System.out.println(E.toString());
            return false;
        }
    }
}
