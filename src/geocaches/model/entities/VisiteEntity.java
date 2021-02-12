package geocaches.model.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table (name = "Visite", schema = "geocaches")
public class VisiteEntity implements Serializable {
    @Id
    @Column(name="idVisite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
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

    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="Utilisateur_idUtilisateur")
        private UtilisateurEntity utilisateur;
    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

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
