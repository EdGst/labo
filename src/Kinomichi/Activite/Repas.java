package Kinomichi.Activite;

import java.time.LocalDateTime;

public class Repas extends Activite{

    int stockRepas;



    public Repas(String nom, LocalDateTime debut, LocalDateTime fin, int stockRepas) {
        super(nom, debut, fin);

        this.stockRepas = stockRepas;
    }

    public int getStockRepas() {
        return stockRepas;
    }

    public void setStockRepas(int stockRepas) {
        this.stockRepas = stockRepas;
    }
}
