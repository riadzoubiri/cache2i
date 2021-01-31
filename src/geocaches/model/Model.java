package geocaches.model;

import geocaches.model.dao.*;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

import java.sql.Date;
import java.util.Collection;


public class Model {
    private UtilisateurDao utilisateurManager;
    private CacheDao cacheManager;
    private VisiteDao visiteManager;
    public Model(){
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.PersistenceType.JPA);
        this.utilisateurManager = daoFactory.getUtilisateursDao();
        this.cacheManager = daoFactory.getCachesDao();
        this.visiteManager = daoFactory.getVisiteDao();
    }

    /**
     * PARTIE UTILISATEUR
     * @return
     */
    public Collection<UtilisateurEntity> getUtilisateurs(){
        return utilisateurManager.findAll();
    }
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

    /**
     * PARTIE CACHE
     * @return
     */

    public CacheEntity creerCache(String description, String gps, UtilisateurEntity utilisateurEntity) {
        CacheEntity cacheEntity = new CacheEntity();
        cacheEntity.setGPS(gps);
        cacheEntity.setDescription(description);
        cacheEntity.setUtilisateur(utilisateurEntity);
        return cacheManager.create(cacheEntity);
    }
    public void suppCache(CacheEntity cacheEntity){
        cacheManager.delete(cacheEntity);
    }
    public Collection<CacheEntity> getCaches(){return cacheManager.findAll();}
    public CacheEntity getCacheById(int id){
        return cacheManager.findById(id);
    }

    /**
     * PARTIE VISITE
     * @return
     */
    public VisiteEntity creerVisite(String photo, String decouverte, String date, String commentaire, UtilisateurEntity utilisateurEntity, CacheEntity cacheEntity) {
        VisiteEntity visiteEntity = new VisiteEntity();
        visiteEntity.setPhoto(photo);
        visiteEntity.setDecouverte(decouverte);
        visiteEntity.setDate(date);
        visiteEntity.setCommentaire(commentaire);
        visiteEntity.setUtilisateur(utilisateurEntity);
        visiteEntity.setCache(cacheEntity);
        return visiteManager.create(visiteEntity);
    }

    public void suppVisite(VisiteEntity visiteEntity){
        visiteManager.delete(visiteEntity);
    }
    public Collection<VisiteEntity> getVisite(){return visiteManager.findAll();}


}
