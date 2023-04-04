package Kinomichi.Activite;

import java.time.LocalDateTime;

public class Logement extends Activite{

    int placeDeLogement;
    public Logement(String nom, LocalDateTime debut, LocalDateTime fin, int placeDeLogement) {
        super(nom, debut, fin);

        this.placeDeLogement = placeDeLogement;
    }

    public int getPlaceDeLogement() {
        return placeDeLogement;
    }

    public void setPlaceDeLogement(int placeDeLogement) {
        this.placeDeLogement = placeDeLogement;
    }
}
