package Jeu.Partie;

import java.util.Scanner;

public class Input {


    public static int InputChiffre(){

        while(true) {
            Scanner s = new Scanner(System.in);
            if (!s.hasNextInt()) {
                System.out.println("Erreur, veuillez choisir un nombre.");
            } else {
                int i = s.nextInt();
                return i;
            }
        }
    }
}
