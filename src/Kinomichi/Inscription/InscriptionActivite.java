package Kinomichi.Inscription;

import Kinomichi.Personne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InscriptionActivite {
    private String nom;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private List<Personne> inscrits = new ArrayList<>();


    public InscriptionActivite(String nom, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public List<Personne> getInscrits() {
        return inscrits;
    }

    public void setInscrits(List<Personne> inscrits) {
        this.inscrits = inscrits;
    }


    public void ajouterInscrit(Personne personne) {
        this.inscrits.add(personne);
    }

    public void supprimerInscrit(Personne personne) {
        this.inscrits.remove(personne);
    }
}