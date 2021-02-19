package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

import java.util.List;

public interface VisiteDao extends Dao<VisiteEntity>{

    public VisiteEntity findById(String id);
    public List<VisiteEntity> findByUser(UtilisateurEntity user);
    public List<VisiteEntity> findByDate(String dateTime);
    public List<VisiteEntity> findByCache(CacheEntity cache);
    public void deleteByUser(UtilisateurEntity user);
    public void deleteByCache(CacheEntity cache);
    public void updateByUser(UtilisateurEntity user);
    public void updateByCache(CacheEntity cache);


}
