package Kinomichi.Personne;

import Kinomichi.Activite.Activite;

import java.util.ArrayList;
import java.util.List;

public class ListePersonne {
    private List<Personne> personne = new ArrayList<>();

    public List<Personne> getListePersonne() {
        return personne;
    }

    public void addpersonne(Personne p){
        this.personne.add(p);
    }

}
