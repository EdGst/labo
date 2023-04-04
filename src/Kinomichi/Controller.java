package Kinomichi;

import Kinomichi.Activite.Activite;
import Kinomichi.Activite.ListeActivite;
import Kinomichi.Horaire.Horaire;
import Kinomichi.Personne.ListePersonne;
import Kinomichi.Personne.Personne;
import Kinomichi.util.Console;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Controller  {

    private ListePersonne p = new ListePersonne();
    private Horaire a = new Horaire();
    private Doublon listePersonnesInscrites = new Doublon();




    // ajouter une personne à la liste
    public void addPersonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.println("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.println("Club: ");
        String club = scanner.nextLine();
        System.out.println("Responsable : ");
        boolean responsable = false;

            System.out.println("Est un responsable ?");
            System.out.println("Oui | Non");

                String choix = scanner.nextLine();

                if (choix.equalsIgnoreCase("Oui"))
                    responsable = true;

        if (p == null){
            System.out.println("je passe ici");
            Personne personne = new Personne(nom, prenom, club, responsable);
            try{
                p.addpersonne(personne);
                System.out.println("Personne.Personne ajoutée: " + personne.getNom() + " " + personne.getPrenom());
            }catch (NullPointerException e){
                System.err.println("A vérifier !");
            }

        } else {
            if (listePersonnesInscrites.verifDoublon(p.getListePersonne(), nom, prenom)){
            System.out.println("Cette personne existe déjà");
        }
        else {
            Personne personne = new Personne(nom, prenom, club, responsable);
            p.addpersonne(personne);
            System.out.println("Personne.Personne ajoutée: " + personne.getNom() + " " + personne.getPrenom());
        }

        }

    }
    public void addActivite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();

        System.out.println("Donnez la date et l'heure du début de l'activité");
        LocalDateTime debut = getDate();
        System.out.println("Donnez la date et l'heure de fin de l'activité");
        LocalDateTime fin = getDate();


            Activite activite = new Activite(nom, debut, fin);


    }
    private static LocalDateTime getDate() {
        // variables
        LocalDateTime date;
        String input;
        String[] tab;
        // tant que le nombre de valeur entré est diff de celle attendu alors on execute la boucle
        do {
            //affichage demande + lecture input user
            System.out.println("Annee.Mois.Jour.Heure.Minute");
            input = Console.lireString();
            tab = input.split("\\.");
        } while (tab.length < 5);
        // création de la date à partie des saisies
        date = LocalDateTime.of(
                Integer.valueOf(tab[0]),
                Integer.valueOf(tab[1]),
                Integer.valueOf(tab[2]),
                Integer.valueOf(tab[3]),
                Integer.valueOf(tab[4]));
        // retourne la date
        return date;
    }



    // Imprimer la liste
    public void printListePersonnes() {
        System.out.println("Liste de personnes: ");
        for (Personne personne : p.getListePersonne()) {
            System.out.println(personne.getNom() + " " + personne.getPrenom() + " " + personne.getClub());
        }

    }

    public void printListeActivite() {
        System.out.println("Liste des activités: ");
        for (Activite activite : a.getListeActivite()) {
            System.out.println(activite.getNom() + " " + activite.getDebut() + " " + activite.getFin());
        }
    }





    // Recherche une personne dans la liste : Sert pour la fonction delete - recherche - modification
    public Personne rechercheP (String nom, String prenom) {
        for (Personne p : p.getListePersonne()) {
            if (p.getNom().equals(nom) && p.getPrenom().equals(prenom)) {
                System.out.printf("Est-ce bien %s %s ? Oui/Non", p.getPrenom(), p.getNom());
                Scanner scan = new Scanner(System.in);
                String choix = scan.nextLine();
                if (choix.equalsIgnoreCase("Oui"))
                    return p;
            }
        }
        return null;
    }
    public Activite rechercheA (String nom, LocalDateTime debut, LocalDateTime fin) {
        for (Activite a : a.getListeActivite()) {
            if (a.getNom().equals(nom) && a.getDebut().equals(debut) && a.getFin().equals(fin)) {
                System.out.printf("Est-ce bien %s %s %s ? Oui/Non", a.getNom(), a.getDebut().toString(), a.getFin().toString());
                Scanner scan = new Scanner(System.in);
                String choix = scan.nextLine();
                if (choix.equalsIgnoreCase("Oui"))
                    return a;
            }
        }
        return null;
    }
    public void supprimerPersonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.println("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.println("Club: ");
        String club = scanner.nextLine();


        Personne personne = rechercheP(nom, prenom);

        if (personne != null){
            this.p.getListePersonne().remove(personne);
            System.out.println("Personne supprimée: " + personne.getNom() + " " + personne.getPrenom());
        }


    }
    public void modifierPersonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de la personne à modifier: ");
        String nom = scanner.nextLine();
        System.out.println("Prénom de la personne à modifier: ");
        String prenom = scanner.nextLine();

        Personne p = rechercheP(nom, prenom);
        if (p == null) {
            System.out.println("Personne introuvable");
            return;
        }

        System.out.println("Personne à modifier: " + p.getPrenom() + " " + p.getPrenom());
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1 - Nom");
        System.out.println("2 - Prénom");
        System.out.println("3 - Club");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> {
                System.out.println("Nouveau nom: ");
                String nouveauNom = scanner.nextLine();
                p.setNom(nouveauNom);
            }
            case 2 -> {
                System.out.println("Nouveau prénom: ");
                String nouveauPrenom = scanner.nextLine();
                p.setPrenom(nouveauPrenom);
            }
            case 3 -> {
                System.out.println("Nouveau club: ");
                String nouveauClub = scanner.nextLine();
                p.setClub(nouveauClub);
            }
            default -> System.out.println("Choix invalide");
        }

        System.out.println("Personne modifiée: "  + p.getPrenom() + " " + p.getNom() + " " + p.getClub());
    }




    // inscrire un participant
    public void inscrirePersonneActivite(String nomActivite, LocalDateTime debut, LocalDateTime fin, String nomPersonne, String prenomPersonne) {
        Activite activite = rechercheA(nomActivite, debut, fin);
        Personne personne = rechercheP(nomPersonne, prenomPersonne);

        activite.ajouterInscrit(personne);
    }

    // désinscrire un participant
    public void desinscrirePersonneActivite(String nomActivite, LocalDateTime debut, LocalDateTime fin, String nomPersonne, String prenomPersonne) {
        Activite activite = rechercheA(nomActivite, debut, fin);
        Personne personne = rechercheP(nomPersonne, prenomPersonne);

        activite.supprimerInscrit(personne);


    }

}
