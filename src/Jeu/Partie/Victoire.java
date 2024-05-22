package Jeu.Partie;

import Jeu.Musique;

public class Victoire {
    public String printVictoire(){
        return """
                 __      __  _          _                              _\s
                 \\ \\    / / (_)        | |                            | |
                  \\ \\  / /   _    ___  | |_    ___    _ __   _   _    | |
                   \\ \\/ /   | |  / __| | __|  / _ \\  | '__| | | | |   | |
                    \\  /    | | | (__  | |_  | (_) | | |    | |_| |   |_|
                     \\/     |_|  \\___|  \\__|  \\___/  |_|     \\__, |   (_)
                                                              __/ |     \s
                                                             |___/      \s
                """;

    }
    public Victoire(){

        System.out.println(printVictoire()) ;
        System.exit(1);
    }
}
