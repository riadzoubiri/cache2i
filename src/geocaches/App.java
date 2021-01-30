package geocaches;

import geocaches.model.Model;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;

public class App {
    public static void main(String[] args) {
        System.out.println("TOMATOOOO");
        new App();
    }

    private Model model;

    public App(){
        this.model = new Model();
        System.out.println(this.model.getUtilisateurs());
        UtilisateurEntity user = this.model.creerUtilisateur("Tutu");
        System.out.println(this.model.getUtilisateurs());
        user.setLogin("Guigui");
        System.out.println(this.model.getUtilisateurs());
        this.model.suppUtilisateur(user);
        System.out.println(this.model.getUtilisateurs());
        System.out.println(this.model.getUtilisateurByLogin("Toto"));

        System.out.println(this.model.getCaches());
        CacheEntity cache = this.model.creerCache("Tu l'as trouvera lorsque les poules auront des dents",this.model.getUtilisateurByLogin("Toto"));
        System.out.println(this.model.getCaches());
        this.model.suppCache(cache);
        System.out.println(this.model.getCaches());
    }
}
