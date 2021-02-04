package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;

import java.util.List;

public interface CacheDao extends Dao<CacheEntity>{

    public CacheEntity findById(int id);
    public List<CacheEntity> findByUser(String userLogin);
    public List<CacheEntity> findByLocation(String location);
}
