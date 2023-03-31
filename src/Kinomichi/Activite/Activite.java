package Kinomichi.Activite;

import Kinomichi.Personne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public void supprimerInscrit(Personne personne) {
        this.inscrits.remove(personne);
    }
}
