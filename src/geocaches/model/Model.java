package geocaches.model;

import geocaches.model.dao.*;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;

import java.util.Collection;

public class Model {
    private UtilisateurDao utilisateurManager;
    private CacheDao cacheManager;
    public Model(){
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA);
        this.utilisateurManager = daoFactory.getUtilisateursDao();
        this.cacheManager = daoFactory.getCachesDao();
    }
    public Collection<UtilisateurEntity> getUtilisateurs(){
        return utilisateurManager.findAll();
    }
    public Collection<CacheEntity> getCaches(){return cacheManager.findAll();}

    public UtilisateurEntity creerUtilisateur(String login){
        UtilisateurEntity utilisateurEntity = new UtilisateurEntity();
        utilisateurEntity.setLogin(login);
        return utilisateurManager.create(utilisateurEntity);
    }
    public void suppUtilisateur(UtilisateurEntity utilisateurEntity){
        utilisateurManager.delete(utilisateurEntity);
    }
    public UtilisateurEntity getUtilisateurByLogin(String login){
        return utilisateurManager.findByLogin(login);
    }

    public CacheEntity creerCache(String description, UtilisateurEntity utilisateurEntity){
        CacheEntity cacheEntity = new CacheEntity();
        cacheEntity.setDescription(description);
        cacheEntity.setUtilisateur(utilisateurEntity);
        return cacheManager.create(cacheEntity);
    }
    public void suppCache(CacheEntity cacheEntity){
        cacheManager.delete(cacheEntity);
    }


}
