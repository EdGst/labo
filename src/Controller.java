import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private List<Personne> personne;

    public Controller() {
        this.personne = new ArrayList<>();
    }
    private ListePersonnesInscrites listePersonnesInscrites = new ListePersonnesInscrites();

    // ajouter une personne à la liste
    public void addPersonne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.println("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.println("Club: ");
        String club = scanner.nextLine();

        if (listePersonnesInscrites.verifDoublon(personne, nom, prenom)){
            System.out.println("Cette personne existe déjà");
        }
        else {
            Personne personne = new Personne(nom, prenom, club);
            this.personne.add(personne);
            System.out.println("Personne ajoutée: " + personne.getNom() + " " + personne.getPrenom());
        }
    }

    // Imprimer la liste
    public void printListePersonnes() {
        System.out.println("Liste de personnes:");
        for (Personne personne : this.personne) {
            System.out.println(personne.getNom() + " " + personne.getPrenom() + " " + personne.getClub());
        }

    }
}
