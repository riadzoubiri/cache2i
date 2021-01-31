package geocaches.model.dao;

import geocaches.model.entities.CacheEntity;

public interface CacheDao extends Dao<CacheEntity>{
    public CacheEntity findById(int id);
}
