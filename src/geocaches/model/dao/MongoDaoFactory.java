package geocaches.model.dao;

public class MongoDaoFactory extends DaoFactory {

        @Override
        public UtilisateurDao getUtilisateursDao() {
            return MongoDaoUtilisateur.getInstance();
        }

        @Override
        public CacheDao getCachesDao() {
            return MongoDaoCache.getInstance();
        }

        @Override
        public VisiteDao getVisiteDao() {
            return MongoDaoVisite.getInstance();
        }

}
