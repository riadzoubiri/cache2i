package geocaches.model;

import geocaches.model.dao.*;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;
import sun.misc.Cache;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


public class Model {
    private UtilisateurDao utilisateurManager;
    private CacheDao cacheManager;
    private VisiteDao visiteManager;
    public Model(){
        DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.PersistenceType.MongoDb);
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
    public boolean modifUtilisateur(UtilisateurEntity user){
        return utilisateurManager.update(user);
    };
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

    public CacheEntity creerCache(String description, String gps, UtilisateurEntity utilisateurEntity,String etat,String nature,String type) {
        CacheEntity cacheEntity = new CacheEntity();
        cacheEntity.setGPS(gps);
        cacheEntity.setDescription(description);
        cacheEntity.setUtilisateur(utilisateurEntity);
        cacheEntity.setEtat(etat);
        cacheEntity.setNature(nature);
        cacheEntity.setType(type);
        return cacheManager.create(cacheEntity);
    }
    public void suppCache(CacheEntity cacheEntity){
        cacheManager.delete(cacheEntity);
    }
    public Collection<CacheEntity> getCaches(){
        return cacheManager.findAll();
    }
    public CacheEntity getCacheById(int id){
        return cacheManager.findById(id);
    }
    public List<CacheEntity> getCacheByUser(UtilisateurEntity user){
        return cacheManager.findByUser(user);
    }
    public List<CacheEntity> getCacheByLocation(String loc){
        return cacheManager.findByLocation(loc);
    }
    public boolean modifCache(CacheEntity cache){
        return cacheManager.update(cache);
    };


    /**
     * PARTIE VISITE
     * @return
     */
    public VisiteEntity creerVisite(String photo, int decouverte, Timestamp date, String commentaire, UtilisateurEntity utilisateurEntity, CacheEntity cacheEntity) {
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
    public Collection<VisiteEntity> getVisites(){return visiteManager.findAll();}
    public VisiteEntity getVisiteById(int id){
        return visiteManager.findById(id);
    }
    public List<VisiteEntity> getVisiteByUser(UtilisateurEntity user){
        return visiteManager.findByUser(user);
    }
    public List<VisiteEntity> getVisiteByDate(String date){
        return visiteManager.findByDate(date);
    }
    public List<VisiteEntity> getVisiteByCache(CacheEntity cache){
        return visiteManager.findByCache(cache);
    }
    public boolean modifVisite(VisiteEntity visite){
        return visiteManager.update(visite);
    };

}
