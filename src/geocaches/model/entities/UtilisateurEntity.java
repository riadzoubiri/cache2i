package geocaches.model.entities;
import dev.morphia.annotations.Reference;

import javax.persistence.*;
import java.io.Serializable;


@dev.morphia.annotations.Entity("UtilisateurEntity")
@Entity
@Table (name = "Utilisateur", schema = "geocaches")
public class UtilisateurEntity implements Serializable {

    @Id
    @dev.morphia.annotations.Id
    @dev.morphia.annotations.Property("id")
    @Column(name="idUtilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name="login")
    private String login;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name="photo")
    private String photo;
    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString(){
        return "UtilisateurEntity {"+ "Id: "+ this.id + " Nom: "+ this.login + " Photo: "+ this.photo + " }";
    }

}
