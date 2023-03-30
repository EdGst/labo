import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListePersonnesInscrites {

    private int cpt=0;
    // List<Personnes> listePersonne = new ArrayList<>();


    public boolean verifDoublon(List<Personne> personne, String nom, String prenom) {

        if (cpt != 0)
            for (Personne p : personne) {

                if (p.getNom().equals(nom) && p.getPrenom().equals(prenom)) {
                    return true;

            }

        }
        this.cpt++;
        return false;
    }

    public void siDoublon(Personne personne){



    }


    public void addListe (){


    }
}
