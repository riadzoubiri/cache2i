package geocaches;

import geocaches.model.Model;
import geocaches.model.entities.CacheEntity;
import geocaches.model.entities.UtilisateurEntity;
import geocaches.model.entities.VisiteEntity;
import java.util.*;
import java.sql.Timestamp;



public class App {

    public static void main(String[] args) {
        new App();
    }

    private Model model;
    private Scanner scanner;
    public void createMultipleCaches(){
        
        UtilisateurEntity riyad=this.model.creerUtilisateur("riyad");
        CacheEntity riyadCache1=this.model.creerCache(
                "la cache 1 de zouzou",
                "41°24'12.2\"N 2°10'26.5\"E",
                riyad,
                "active",
                "physique",
                "piste");

        CacheEntity riyadCache2=this.model.creerCache(
                "la cache 2 de zouzou",
                "41°24'12.2\"N 2°10'26.5\"E",
                riyad,
                "activation",
                "virtuelle",
                "objet");

        CacheEntity riyadCache3=this.model.creerCache(
                "la cache 3 de zouzou",
                "41°24'12.2\"N 2°10'26.5\"E",
                riyad,
                "fermee",
                "physique",
                "voyageur");
    }

    public void createMultipleVisites(){
        
        UtilisateurEntity riyad=this.model.creerUtilisateur("zouzou");
        CacheEntity riyadCache1=this.model.creerCache(
                "la cache 1 de riyad",
                "41°24'12.2\"N 2°10'26.5\"E",
                riyad,
                "active",
                "physique",
                "piste");

        CacheEntity riyadCache2=this.model.creerCache(
                "la cache 2 de riyad",
                "41°24'12.2\"N 2°10'26.5\"E",
                riyad,
                "activation",
                "virtuelle",
                "objet");

        VisiteEntity visite1=this.model.creerVisite(
                "",
                1,
                new Timestamp(System.currentTimeMillis()),
                "Je t'ai trouvvvéééé",
                riyad,
                riyadCache1
        );

        VisiteEntity visite2=this.model.creerVisite(
                "",
                2,
                new Timestamp(System.currentTimeMillis()),
                "Je t'ai trouvvvéééé",
                riyad,
                riyadCache2
        );
    }

    public void createMultipleUsers(){
        
        UtilisateurEntity riyad=this.model.creerUtilisateur("rizou");
        UtilisateurEntity victo=this.model.creerUtilisateur("victo");
    }

    public void getAllUsers(){
        
        Collection<UtilisateurEntity> users=this.model.getUtilisateurs();
        System.out.println(users);
    }

    public void getAllCaches(){
        
        Collection<CacheEntity> caches=this.model.getCaches();
        System.out.println(caches);
    }

    public void getAllVisites(){
        
        Collection<VisiteEntity> visites=this.model.getVisites();
        System.out.println(visites);
    }

    public void getVisiteByUser(){
        
        
        System.out.println("User Login :");
        String userLogin=scanner.next();
        Collection<VisiteEntity> visites=this.model.getVisiteByUser(
                this.model.getUtilisateurByLogin(userLogin)
        );
        System.out.println(visites);
    }

    public void getVisiteByCache(){
        
        
        System.out.println("Cache id :");
        String cache=scanner.next();
        Collection<VisiteEntity> visites=this.model.getVisiteByCache(
                this.model.getCacheById(Integer.parseInt(cache))
        );
        System.out.println(visites);
    }

    public void modifyUser(){
        
        
        System.out.println("User Login :");
        String userLogin=scanner.next();
        UtilisateurEntity user=this.model.getUtilisateurByLogin(userLogin);
        System.out.println("New Login :");
        String newLogin=scanner.next();
        user.setLogin(newLogin);
        this.model.modifUtilisateur(user);
    }

    public void deleteUser(){
        System.out.println("User Login :");
        String userLogin=scanner.next();
        UtilisateurEntity user=this.model.getUtilisateurByLogin(userLogin);
        this.model.suppUtilisateur(user);
    }

    public void modifyCache(){
        
        
        System.out.println("Cache id :");
        String cacheId=scanner.next();
        CacheEntity cache=this.model.getCacheById(Integer.parseInt(cacheId));
        System.out.println("New description :");
        String description=scanner.next();
        cache.setDescription(description);
        this.model.modifCache(cache);
    }

    public void deleteCache(){
        
        
        System.out.println("Cache id :");
        String cacheId=scanner.next();
        CacheEntity cache=this.model.getCacheById(Integer.parseInt(cacheId));
        this.model.suppCache(cache);
    }

    public void modifyVisite(){
        
        System.out.println("Visite id :");
        String visiteID=scanner.next();
        VisiteEntity visite=this.model.getVisiteById(Integer.parseInt(visiteID));
        System.out.println("New comment :");
        String comment=scanner.next();
        visite.setCommentaire(comment);
        this.model.modifVisite(visite);
    }

    public void deleteVisite(){
        
        System.out.println("Visite id :");
        String visiteID=scanner.next();
        VisiteEntity visite=this.model.getVisiteById(Integer.parseInt(visiteID));
        this.model.suppVisite(visite);
    }

    private void showMenu() {
        System.out.println("1 - Utilisateurs");
        System.out.println("2 - Caches");
        System.out.println("3 - Visites");
        System.out.println("0 - Sortir");
    }

    private void showUserMenu(){
        
        String choice="";
        do{
            System.out.println("1 - Création d'utlisateurs");
            System.out.println("2 - Affichage d'utlisateurs");
            System.out.println("3 - Modification d'utlisateurs ");
            System.out.println("4 - Suppression d'utlisateurs ");
            System.out.println("0 - Sortir");
            choice = scanner.next();
            switch (choice)
            {
                case "1":
                    createMultipleUsers();
                    break;
                case "2":
                    getAllUsers();
                    break;
                case "3":
                    modifyUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (!choice.equals("0"));

    }

    private void showCacheMenu(){
        
        String choice="";
        do{
            System.out.println("1 - Création de caches");
            System.out.println("2 - Affichage de caches");
            System.out.println("3 - Modification de caches ");
            System.out.println("4 - Suppression de caches ");
            System.out.println("0 - Sortir");
            choice = scanner.next();
            switch (choice)
            {
                case "1":
                    createMultipleCaches();
                    break;
                case "2":
                    getAllCaches();
                    break;
                case "3":
                    modifyCache();
                    break;
                case "4":
                    deleteCache();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (!choice.equals("0"));
    }

    private void showVisiteMenu(){
        
        String choice="";
        do{
            System.out.println("1 - Création de visites");
            System.out.println("2 - Affichage de visites");
            System.out.println("3 - Modification de visites ");
            System.out.println("4 - Suppression de visites ");
            System.out.println("5 - Affichage de visites par utilisateur");
            System.out.println("6 - Affichage de visites par Cache");
            System.out.println("0 - Sortir");
            choice = scanner.next();
            switch (choice)
            {
                case "1":
                    createMultipleVisites();
                    break;
                case "2":
                    getAllVisites();
                    break;
                case "3":
                    modifyVisite();
                    break;
                case "4":
                    deleteVisite();
                    break;
                case "5":
                    getVisiteByUser();
                    break;
                case "6":
                    getVisiteByCache();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (!choice.equals("0"));
    }

    public App(){
        this.scanner = new Scanner(System.in);
        this.model=new Model();
        String choice="";
        do{
            showMenu();
            choice = scanner.next();
            switch (choice)
            {
                case "1":
                    showUserMenu();
                    break;
                case "2":
                    showCacheMenu();
                    break;
                case "3":
                    showVisiteMenu();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (!choice.equals("0"));
    }

}
