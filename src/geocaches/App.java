package geocaches;

import geocaches.model.Model;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;

public class App {
    public static void main(String[] args) {
        new App();
    }

    private Model model;

    public App(){
        /**
         * Affichage Partie Utilisateur
         */
        this.model = new Model();
        System.out.println(this.model.getUtilisateurs());
        UtilisateurEntity user = this.model.creerUtilisateur("Tutu");
        System.out.println(this.model.getUtilisateurs());
        user.setLogin("Guigui");
        System.out.println(this.model.getUtilisateurs());
        this.model.suppUtilisateur(user);
        System.out.println(this.model.getUtilisateurs());
        System.out.println(this.model.getUtilisateurByLogin("Toto"));

        /**
         * Affichage Partie Cache
         **/
        System.out.println(this.model.getCaches());
        CacheEntity cache = this.model.creerCache("Tu l'as trouvera lorsque les poules auront des dents","45N;67E",this.model.getUtilisateurByLogin("Toto"));
        System.out.println(this.model.getCaches());
        cache.setUtilisateur(this.model.getUtilisateurByLogin("Titi"));
        cache.setGPS("39° 17′ N, 76° 36′ O");
        System.out.println(this.model.getCaches());
        this.model.suppCache(cache);
        System.out.println(this.model.getCaches());

        /**
         * Affichage Partie Visite
         */
        System.out.println(this.model.getVisite());
        VisiteEntity visite = this.model.creerVisite("^_^", "3","2021-01-12","Bien caché !", this.model.getUtilisateurByLogin("Toto"),this.model.getCacheById(1));
        System.out.println(this.model.getVisite());
        visite.setUtilisateur(this.model.getUtilisateurByLogin("Titi"));
        visite.setPhoto("°-°");
        System.out.println(this.model.getVisite());
        this.model.suppVisite(visite);
        System.out.println(this.model.getVisite());

    }

}
