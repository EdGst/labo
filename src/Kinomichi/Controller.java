package Kinomichi;

import Kinomichi.Activite.Activite;
import Kinomichi.Activite.ListActivites;
import Kinomichi.Horaire.Horaire;
import Kinomichi.Personne.ListePersonne;
import Kinomichi.Personne.Personne;
import Kinomichi.util.Console;
import Kinomichi.util.Doublon;


import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private ListePersonne listePersonne = new ListePersonne();
    private Horaire listeActivite = new Horaire();
    private Doublon listePersonnesInscrites = new Doublon();
    private ListActivites listActivites = new ListActivites();
    private Scanner scanner = new Scanner(System.in);


    // ajouter une personne à la liste
    public void addPersonne() {

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

        if (listePersonne == null) {
            System.out.println("je passe ici");
            Personne personne = new Personne(nom, prenom, club, responsable);
            try {
                listePersonne.addpersonne(personne);
                System.out.println("Personne.Personne ajoutée: " + personne.getNom() + " " + personne.getPrenom());
            } catch (NullPointerException e) {
                System.err.println("A vérifier !");
            }

        } else {
            if (listePersonnesInscrites.verifDoublon(listePersonne.getListePersonne(), nom, prenom)) {
                System.out.println("Cette personne existe déjà");
            } else {
                Personne personne = new Personne(nom, prenom, club, responsable);
                listePersonne.addpersonne(personne);
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
        listeActivite.trieHoraire(activite);


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
        for (Personne personne : listePersonne.getListePersonne()) {
            System.out.println(personne.getNom() + " " + personne.getPrenom() + " " + personne.getClub());
        }

    }

    public void printListeActivite() {

        System.out.println("Liste des activités: ");
        for (Activite activite : listeActivite.getListeActivite()) {
            System.out.println(listeActivite.getListeActivite().indexOf(activite)+ 1 + " : " + activite.getNom() + " | " + activite.getDebut() + " | " + activite.getFin());

        }
    }

    public void printActiviteEtParticipants() {

        int index;

        printListeActivite();

        do {
            System.out.println("Choisir le numéro de l'activité : ");
            Scanner scanner = new Scanner(System.in);
            index = Integer.parseInt(scanner.nextLine())-1;
        } while (index < 0 || index > listeActivite.getListeActivite().size());


        Activite activite = listeActivite.getListeActivite().get(index);

        System.out.println("Activité : " + activite.getNom());
        System.out.println("Participants :");
        for (Personne personne : activite.getListeParticipants()) {
            System.out.println(personne.getNom() + " " + personne.getPrenom());

        }
    }

    public void printActiviteParParticipants() {

//        System.out.println("Nom: ");
//        String nom = scanner.nextLine();
//        System.out.println("Prénom: ");
//        String prenom = scanner.nextLine();
//        System.out.println("Club: ");
//        String club = scanner.nextLine();

        for ( Personne p : listePersonne.getListePersonne()) {

            System.out.println(listePersonne.getListePersonne().indexOf(p)+1+" "+p);

        }
        System.out.println("entrez le numéro");
        String input=new Scanner(System.in).nextLine();
        int index = Integer.parseInt(input)-1;

        Personne p1 = listePersonne.getListePersonne().get(index);  // pour comparer en dessous

        System.out.println("TEST DEBUT");
        MyComparator myComparator=new MyComparator();
        int cpt=0;
        for (Activite a : listeActivite.getListeActivite()) {
            System.out.println("TEST 1ere boucle");
            for (Personne p :listePersonne.getListePersonne()){
                System.out.println("TEST 2eme boucle");
                if (myComparator.compare(p1,p)==0){
                    System.out.println("TEST IF");
                    cpt++;
                    System.out.println(cpt+" "+a.toString(p));
                }
            }
        }
    }


    // Recherche une personne dans la liste : Sert pour la fonction delete - recherche - modification

    public Personne rechercheP(String nom, String prenom) {
        Scanner scan = new Scanner(System.in);
        for (Personne p : listePersonne.getListePersonne()) {
            if (p.getNom().equalsIgnoreCase(nom) && p.getPrenom().equalsIgnoreCase(prenom)) {
                System.out.printf("Est-ce bien %s %s ? Oui/Non", p.getPrenom(), p.getNom());
                while (true) {
                    try {
                        String choix = scan.nextLine();
                        if (choix.equalsIgnoreCase("oui")) {
                            return p;
                        } else if (choix.equalsIgnoreCase("non")) {
                            break;
                        } else {
                            System.out.println("Veuillez répondre par 'oui' ou 'non'");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Veuillez saisir une réponse valide : 'oui' ou 'non'");
                        scan.nextLine(); // consommer la saisie invalide
                    }
                }
            }
        }
        return null;
    }

    public Activite rechercheA(String nom, LocalDateTime debut, LocalDateTime fin) {
        Scanner scan = new Scanner(System.in);
        for (Activite a : listeActivite.getListeActivite()) {
            if (a.getNom().equalsIgnoreCase(nom) && a.getDebut().equals(debut) && a.getFin().equals(fin)) {
                System.out.printf("Est-ce bien %s %s %s ? Oui/Non", a.getNom(), a.getDebut().toString(), a.getFin().toString());
                while (true) {
                    try {
                        String choix = scan.nextLine();
                        if (choix.equalsIgnoreCase("oui")) {
                            return a;
                        } else if (choix.equalsIgnoreCase("non")) {
                            break;
                        } else {
                            System.out.println("Veuillez répondre par 'oui' ou 'non'");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Veuillez saisir une réponse valide : 'oui' ou 'non'");
                        scan.nextLine();
                    }
                }
            }
        }
        return null;
    }

    public void supprimerPersonne() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        Personne personne = null;

        while (!isValidInput) {
            System.out.println("Nom: ");
            String nom = scanner.nextLine();
            System.out.println("Prénom: ");
            String prenom = scanner.nextLine();
            System.out.println("Club: ");
            String club = scanner.nextLine();

            personne = rechercheP(nom, prenom);
            if (personne == null) {
                System.out.println("Personne non trouvée. Veuillez réessayer.");
            } else if (!personne.getClub().equals(club)) {
                System.out.println("Le club saisi ne correspond pas à la personne. Veuillez réessayer.");
            } else {
                isValidInput = true;
            }
        }

        this.listePersonne.getListePersonne().remove(personne);
        System.out.println("Personne supprimée: " + personne.getNom() + " " + personne.getPrenom());
    }

    public void supprimerActivite() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        LocalDateTime debut = null;
        LocalDateTime fin = null;

        System.out.println("Nom de l'activité: ");
        String nom = scanner.nextLine();

        while (!isValidInput) {

            try {
                System.out.println("Donnez la date et l'heure du début de l'activité");
                debut = getDate();
                System.out.println("Donnez la date et l'heure de fin de l'activité");
                fin = getDate();
            } catch (DateTimeException e) {
                System.out.println("Saisie invalide");
            }

        }
        Activite activite = rechercheA(nom, debut, fin);

        if (activite != null) {
            this.listeActivite.getListeActivite().remove(activite);
            System.out.println("Personne supprimée: " + activite.getNom() + " " + activite.getDebut() + " " + activite.getFin());
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

        int choix = 0;
        while (choix < 1 || choix > 3) {
            System.out.println("Entrez votre choix (1-3) : ");
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

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

        System.out.println("Personne modifiée: " + p.getPrenom() + " " + p.getNom() + " " + p.getClub());
    }

    public void modifierActivite() {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        LocalDateTime debut = null;
        LocalDateTime fin = null;

        System.out.println("Nom: ");
        String nom = scanner.nextLine();


        do {
            isValidInput = true;

            try {
                System.out.println("Donnez la date et l'heure du début de l'activité");
                debut = getDate();
                System.out.println("Donnez la date et l'heure de fin de l'activité");
                fin = getDate();


            } catch (DateTimeException e) {
                System.err.println("saisie invalide");
                isValidInput = false;
            }

        } while (!isValidInput);


        Activite a = rechercheA(nom, debut, fin);
        if (listePersonne == null) {
            System.out.println("Activité introuvable");
            return;
        }

        System.out.println("Activité à modifier: " + a.getNom() + " " + a.getDebut() + " " + a.getFin());
        System.out.println("Que voulez-vous modifier?");
        System.out.println("1 - Nom");
        System.out.println("2 - Heure début");
        System.out.println("3 - Heure fin");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> {
                System.out.println("Nouveau nom: ");
                String nouveauNom = scanner.nextLine();
                a.setNom(nouveauNom);
            }
            case 2 -> {
                System.out.println("Nouveau début: ");
                LocalDateTime nouveauDebut = getDate();
                a.setDebut(nouveauDebut);
            }
            case 3 -> {
                System.out.println("Nouvelle fin: ");
                LocalDateTime nouvelleFin = getDate();
                a.setFin(nouvelleFin);
            }
            default -> System.out.println("Choix invalide");
        }

        System.out.println("Activité modifiée: " + a.getNom() + " " + a.getDebut() + " " + a.getFin());
    }


    // inscrire un participant
    public void inscrirePersonneActivite() {
        System.out.println("Quelle personne voulez-vous inscrire ?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nomPersonne = scanner.nextLine();
        System.out.println("Prénom: ");
        String prenom = scanner.nextLine();

        Personne personne = rechercheP(nomPersonne, prenom);

        if (personne == null) {
            System.out.println("Personne introuvable");
            return;
        }

        System.out.println("Quelle activité va-t-elle rejoindre ?");

        System.out.println("Nom: ");
        String nomActivite = scanner.nextLine();
        boolean isValidInput = false;
        LocalDateTime debut = null;
        LocalDateTime fin = null;

        while (!isValidInput) {

            try {
                System.out.println("Donnez la date et l'heure du début de l'activité");
                debut = getDate();
                System.out.println("Donnez la date et l'heure de fin de l'activité");
                fin = getDate();

                isValidInput = true;
            } catch (DateTimeException e) {
                System.out.println("Saisie invalide");
            }

        }

        Activite activite = rechercheA(nomActivite, debut, fin);
        if (activite == null) {
            System.out.println("Activité introuvable");
            return;
        }

        activite.ajouterInscrit(personne);
    }

    // désinscrire un participant
    public void desinscrirePersonneActivite(String nomActivite, LocalDateTime debut, LocalDateTime fin, String nomPersonne, String prenomPersonne) {
        Activite activite = rechercheA(nomActivite, debut, fin);
        Personne personne = rechercheP(nomPersonne, prenomPersonne);

        activite.supprimerInscrit(personne);


    }

}
