package geocaches.model.dao;

public class JpaDaoFactory extends DaoFactory{
    @Override
    public UtilisateurDao getUtilisateursDao() {
        return JpaDaoUtilisateur.getInstance();
    }

    @Override
    public CacheDao getCachesDao() {
        return JpaDaoCache.getInstance();
    }
}
