package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

import java.util.List;

public interface CacheDao extends Dao<CacheEntity>{

    public CacheEntity findById(int id);
    public List<CacheEntity> findByUser(UtilisateurEntity user);
    public List<CacheEntity> findByLocation(String location);
}
