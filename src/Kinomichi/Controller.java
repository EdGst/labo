package Kinomichi;

import Kinomichi.Activite.Activite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private List<Personne> personne;
    private List<Activite> activite;

    public Controller() {
        this.personne = new ArrayList<>();
    }
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



        if (listePersonnesInscrites.verifDoublon(personne, nom, prenom)){
            System.out.println("Cette personne existe déjà");
        }
        else {
            Personne personne = new Personne(nom, prenom, club, responsable);
            this.personne.add(personne);
            System.out.println("Personne.Personne ajoutée: " + personne.getNom() + " " + personne.getPrenom());
        }
    }
    public void addActivite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.println("Heure debut: ");
        LocalDateTime debut = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Heure fin: ");
        LocalDateTime fin = LocalDateTime.parse(scanner.nextLine());

        if (listePersonnesInscrites.verifDoublonActivite(activite, nom, debut, fin)){
           System.out.println("Cette personne existe déjà");
        }
        else {
            Activite activite = new Activite(nom, debut, fin);
            this.activite.add(activite);
            System.out.println("Personne.Personne ajoutée: " + activite.getNom() + " " + activite.getDebut() + " " + activite.getFin());
        }
    }

    // Imprimer la liste
    public void printListePersonnes() {
        System.out.println("Liste de personnes:");
        for (Personne personne : this.personne) {
            System.out.println(personne.getNom() + " " + personne.getPrenom() + " " + personne.getClub());
        }

    }

    // Recherche une personne dans la liste : Sert pour la fonction delete - recherche - modification
    public Personne rechercheP (String nom, String prenom) {
        for (Personne p : personne) {
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
        for (Activite a : activite) {
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


        Personne p = rechercheP(nom, prenom);

        if (p != null){
            this.personne.remove(p);
            System.out.println("Personne supprimée: " + p.getNom() + " " + p.getPrenom());
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

        System.out.println("Personne à modifier: " + p);
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

        System.out.println("Personne modifiée: " + p);
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
