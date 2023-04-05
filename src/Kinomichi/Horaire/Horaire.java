package Kinomichi.Horaire;

import Kinomichi.Activite.Activite;

import java.lang.reflect.Array;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Horaire {
    //    List<LocalDateTime> date;
    ArrayList<Activite> listeActiviteHoraire = new ArrayList<>();
    List<Horaire> horaireParJour;





//    public void trieHoraire(Activite activite) {
//
//        LocalDateTime debut = activite.getDebut();
//
//        int index = 0;
//        if (listeActiviteHoraire.isEmpty()){
//            System.out.println("TEST 1");
//            listeActiviteHoraire.add(activite);
//        } else {
//        for (Activite l : listeActiviteHoraire) {
//            System.out.println("TEST 2");
//            if (debut.isBefore(l.getDebut())) {
//                System.out.println("TEST 3");
//                debut = (listeActiviteHoraire.set(index, activite)).getDebut();
//
//            }
//            index++;
//        }
//        System.out.println("TEST FIN");
//        }
//
//
//    }

    public void trieHoraire(Activite activite) {
        LocalDateTime debut = activite.getDebut();

        if (listeActiviteHoraire.isEmpty()) {
            listeActiviteHoraire.add(activite);
        } else {
            int index = 0;
            for (Activite l : listeActiviteHoraire) {
                if (debut.isBefore(l.getDebut())) {
                    listeActiviteHoraire.add(index, activite);   // Quand on utilise un index, le déplacement vers la droite se fait automatiquement
                    return;
                }
                index++;
            }
            listeActiviteHoraire.add(activite);
        }
    }


    public List<Activite> getListeActivite() {
        return listeActiviteHoraire;
    }

}

