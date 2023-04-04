package Kinomichi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public static String lireString() {
        String resultat = null;
        BufferedReader lecteur;
        try {
            lecteur = new BufferedReader(new InputStreamReader(System.in));
            resultat = lecteur.readLine();
        } catch (IOException e) {
            System.err.println("Erreur dans Console.lireString");
        }
        return resultat;
    }

    public static char lireChar() {
        char resultat = '\0';
        try {
            String saisie = lireString();
            resultat = saisie.charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            //System.err.println("/!\\ Champs vide /!\\");
        }
        return resultat;
    }

    public static int lireInt() {
        int resultat = 0;
        try {
            String saisie = lireString();
            resultat = Integer.parseInt(saisie);
        } catch (NumberFormatException e) {
            System.err.println("Erreur dans Console.lireInt");
        }
        return resultat;
    }

    public static long lireLong() {
        long resultat = 0l;
        try {
            String saisie = lireString();
            resultat = Long.parseLong(saisie);
        } catch (NumberFormatException e) {
            System.err.println("Erreur dans Console.lireLong");
        }
        return resultat;
    }

    public static float lireFloat() {
        float resultat = 0f;
        try {
            String saisie = lireString();
            resultat = Float.parseFloat(saisie);
        } catch (NumberFormatException e) {
            System.err.println("Erreur dans Console.lireFloat");
        }
        return resultat;
    }

    public static double lireDouble() {
        double resultat = 0.;
        try {
            String saisie = lireString();
            resultat = Double.parseDouble(saisie);
        } catch (NumberFormatException e) {
            System.err.println("Erreur dans Console.lireDouble");
        }
        return resultat;
    }

}