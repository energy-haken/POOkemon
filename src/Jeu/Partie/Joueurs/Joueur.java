package Jeu.Partie.Joueurs;

import Jeu.Partie.Defausse;

import java.util.Random;

public class Joueur {
    private Pioche m_piochePrivee = new Pioche();
    private Main m_mainPrivee = new Main();
    private Defausse m_defaussePrivee = new Defausse();

    public Pioche getPiocheJoueur() {
        return m_piochePrivee;
    }



    /**
     * Rajoute un Pokemon dans la main du joueur provenant de la pioche, le Pokemon est saisi aleatoirement
     */
    public void ajoutMain() {
        Random r = new Random();
        int randomPokemon = r.nextInt(m_piochePrivee.getNombrePokemonDansLaPioche());
        m_mainPrivee.ajouterDansMain(m_piochePrivee.getPokemonDansLaPioche(randomPokemon));
        m_piochePrivee.removePokemonDansLaPioche(randomPokemon);

    }

    public Main getMainPrivee() {
        return m_mainPrivee;
    }
}
