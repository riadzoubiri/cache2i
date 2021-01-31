package geocaches.model.dao;

public abstract class DaoFactory {
    public enum PersistenceType{
        JPA,
        JDBC,
        XML
    };
    public static DaoFactory getDaoFactory(PersistenceType type) {
        switch (type) {
            case JPA:
                return new JpaDaoFactory();
            case JDBC:
                throw new UnsupportedOperationException("JDBC DAO not implemented");
            case XML:
                throw new UnsupportedOperationException("XML DAO not implemented");
            default:
                throw new UnsupportedOperationException("DAO not implemented");
        }
    }

    public abstract UtilisateurDao getUtilisateursDao();
    public abstract CacheDao getCachesDao();
    public abstract VisiteDao getVisiteDao();

}
