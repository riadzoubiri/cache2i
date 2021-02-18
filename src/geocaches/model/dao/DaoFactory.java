package geocaches.model.dao;

public abstract class DaoFactory {
    public enum PersistenceType{
        JPA,
        MongoDb
    };
    public static DaoFactory getDaoFactory(PersistenceType type) {
        switch (type) {
            case JPA:
                return new JpaDaoFactory();
            case MongoDb:
                return new MongoDaoFactory();
            default:
                throw new UnsupportedOperationException("DAO not implemented");
        }
    }

    public abstract UtilisateurDao getUtilisateursDao();
    public abstract CacheDao getCachesDao();
    public abstract VisiteDao getVisiteDao();

}
