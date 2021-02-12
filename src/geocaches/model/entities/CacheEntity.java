package geocaches.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Cache", schema = "geocaches")
public class CacheEntity implements Serializable {

    @Id
    @Column(name="idCache")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }

    @Column(name= "GPS")
    private String gps;
    public String getGPS() {
        return gps;
    }
    public void setGPS(String gps) {
        this.gps = gps;
    }

    @Column(name="description")
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name= "type")
    private String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Column(name= "nature")
    private String nature;
    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {
        this.nature = nature;
    }

    @Column(name= "etat")
    private String etat;
    public String getetat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    @ManyToOne(cascade=CascadeType.REMOVE)
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
        return "Cache {"+ "Id: "+ this.id +" GPS:"  + this.gps+ " Description: "+ this.description + " \nUtilisateur: "+ this.utilisateur + " }";
    }

}
