package geocaches.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Utilisateur", schema = "geocaches")
public class UtilisateurEntity implements Serializable {

    @Id
    @Column(name="idUtilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
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
