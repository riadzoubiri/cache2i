package geocaches.model.entities;
import dev.morphia.annotations.Reference;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table (name = "Visite", schema = "geocaches")
public class VisiteEntity implements Serializable {
    @Id
    @dev.morphia.annotations.Id
    @dev.morphia.annotations.Property("id")
    @Column(name="idVisite")
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name= "photo")
    private String photo;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name= "decouverte")
    private int decouverte;
    public int getDecouverte() {
        return decouverte;
    }
    public void setDecouverte(int decouverte) {this.decouverte = decouverte;
    }

    @Column(name= "date")
    private Timestamp date;
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {this.date = date;
    }

    @Column(name= "commentaire")
    private String commentaire;
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {this.commentaire = commentaire;
    }

    @dev.morphia.annotations.Embedded
    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="Utilisateur_idUtilisateur")
        private UtilisateurEntity utilisateur;
    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    @dev.morphia.annotations.Embedded
    @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="Cache_idCache")
    private CacheEntity cache;
    public CacheEntity getCache() {
        return cache;
    }
    public void setCache(CacheEntity cache) {
        this.cache = cache;
    }

    @Override
    public String toString(){
        return "Visite {"+ "Id: "+ this.id +" photo:"  + this.photo+ " Nombre de fois découverte: "+ this.decouverte + " date: "+ this.date + " Commentaire: "+ this.commentaire + " \nUtilisateur: "+ this.utilisateur + " \nCache: "+ this.cache +" }";
    }
}
