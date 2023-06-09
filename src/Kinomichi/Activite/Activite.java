package Kinomichi.Activite;

import Kinomichi.Personne.Personne;
import Kinomichi.util.Console;


import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Activite {

    String nom;
    LocalDateTime debut;
    LocalDateTime fin;
    private List<Personne> inscrits = new ArrayList<>();



    public Activite(String nom, LocalDateTime debut, LocalDateTime fin){
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDebut() {
        return debut;
    }
    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }



    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public void ajouterInscrit(Personne personne) {
        this.inscrits.add(personne);
    }

    public List<Personne> getListeParticipants () {
        return inscrits;
    }
    public void supprimerInscrit(Personne personne) {
        this.inscrits.remove(personne);
    }

    public void add(Activite activite) {
    }


    public String toString(Personne p) {
        int index = inscrits.indexOf(p);
        return "Activite{" +
                " Nom de l'activité :'" + nom  +
                " \n\n "  +
//                ", debut=" + debut +
//                ", fin=" + fin +
                "Inscrits : " + inscrits.get(index).getNom() + " "+ inscrits.get(index).getPrenom() + " " + inscrits.get(index).getClub() +
                '}';
    }
}
