package Kinomichi.util;

import java.util.Scanner;

public class recherchePersonne {

    public void recherche(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom: ");
        String nom = scanner.nextLine();
        System.out.println("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.println("Club: ");
        String club = scanner.nextLine();
    }
}
