package Kinomichi;

import Kinomichi.Activite.Activite;

import java.time.LocalDateTime;
import java.util.List;

public class Doublon {

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

    public boolean verifDoublonActivite(List<Activite> activite, String nom, LocalDateTime debut, LocalDateTime fin) {

        if (cpt != 0)
            for (Activite a : activite) {

                if (a.getNom().equals(nom) && a.getDebut().equals(debut) && a.getFin().equals(fin)) {
                    return true;

                }

            }
        this.cpt++;
        return false;
    }



}
