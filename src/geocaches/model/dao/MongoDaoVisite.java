package geocaches.model.dao;

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
    public VisiteEntity findById(int id) {
        return null;
    }

    @Override
    public List<VisiteEntity> findByUser(UtilisateurEntity user) {
        return null;
    }

    @Override
    public List<VisiteEntity> findByDate(String dateTime) {
        return null;
    }

    @Override
    public List<VisiteEntity> findByCache(CacheEntity cache) {
        return null;
    }
}