package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

import java.util.List;

public interface CacheDao extends Dao<CacheEntity>{

    public CacheEntity findById(String id);
    public List<CacheEntity> findByUser(UtilisateurEntity user);
    public List<CacheEntity> findByLocation(String location);
    public void deleteByUser(UtilisateurEntity user);
    public void updateByUser(UtilisateurEntity user);
}
