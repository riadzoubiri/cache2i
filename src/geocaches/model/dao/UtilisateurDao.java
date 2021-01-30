package geocaches.model.dao;

import geocaches.model.entities.UtilisateurEntity;

import java.util.Collection;

public interface UtilisateurDao extends Dao<UtilisateurEntity> {
    public UtilisateurEntity findByLogin(String login);
}
