package geocaches.model.dao;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.*;
import geocaches.model.entities.UtilisateurEntity;


import java.util.Collection;

public class MongoDaoUtilisateur extends MongoDao<UtilisateurEntity> implements UtilisateurDao {
    private static geocaches.model.dao.MongoDaoUtilisateur instance;



    public static geocaches.model.dao.MongoDaoUtilisateur getInstance() {
        if(instance==null){
            instance = new geocaches.model.dao.MongoDaoUtilisateur();
        }
        return instance;
    }

    public MongoDaoUtilisateur() {
        super(UtilisateurEntity.class);
    }


    @Override
    public Collection<UtilisateurEntity> findAll() {
        Morphia morphia=new Morphia();
        morphia.mapPackage("geocaches.model.entities");
        Datastore datastore= morphia.createDatastore(mongoClient,"geocache");
        Query<UtilisateurEntity> query = datastore.find(UtilisateurEntity.class);
        return query.asList();
    }

    @Override
    public UtilisateurEntity findByLogin(String login) {
       return null;
    }
}
