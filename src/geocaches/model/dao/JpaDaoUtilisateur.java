package geocaches.model.dao;

import geocaches.model.entities.UtilisateurEntity;

import org.hibernate.query.Query;
import java.util.Collection;

public class JpaDaoUtilisateur extends JpaDao<UtilisateurEntity> implements UtilisateurDao{
    private static JpaDaoUtilisateur instance;

    public static JpaDaoUtilisateur getInstance() {
        if(instance==null){
            instance = new JpaDaoUtilisateur();
        }
        return instance;
    }
    private JpaDaoUtilisateur(){
    }


    @Override
    public Collection<UtilisateurEntity> findAll() {
        Query query = session.createQuery("SELECT a FROM UtilisateurEntity a");
        return query.getResultList();
    }

    @Override
    public UtilisateurEntity findByLogin(String login) {
        Query query= session.createQuery("select a from UtilisateurEntity a where a.login=:log");
        query.setParameter("log",login);
        return (UtilisateurEntity) query.getSingleResult();
    }
}
