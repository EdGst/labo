package Kinomichi.Horaire;

import Kinomichi.Activite.Activite;

import java.lang.reflect.Array;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class Horaire {
    //    List<LocalDateTime> date;
    ArrayList<Activite> listeActiviteHoraire;
    List<Horaire> horaireParJour;



    public void trieHoraire(Activite activite) {

        LocalDateTime debut = activite.getDebut();

        int index = 0;
        for (Activite l : listeActiviteHoraire) {

            if (debut.isBefore(l.getDebut())){

                debut = (listeActiviteHoraire.set(index, activite)).getDebut();

            }
        index++;
        }


    }

    public List<Activite> getListeActivite() {
        return listeActiviteHoraire;
    }
}

