package geocaches.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "cache", schema = "geocaches")
public class CacheEntity implements Serializable {

    @Id
    @Column(name="idCache")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }

    @Column(name="description")
    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name="Utilisateur_idUtilisateur")
    private UtilisateurEntity utilisateur;
    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString(){
        return "Cache {"+ "Id: "+ this.id + " Description: "+ this.description + " Utilisateur: "+ this.utilisateur + " }";
    }

}
