package Jeu.Partie.Joueurs;

import Jeu.Partie.NomPokemon;
import Jeu.Partie.Terrain;

import java.util.Random;

public class Joueur {

    private Pioche m_piochePrivee = new Pioche();
    private Main m_mainPrivee = new Main();
    private Terrain m_terrainPrivee = new Terrain(this);



    public Pioche getPiocheJoueur() {
        return m_piochePrivee;
    }



    /**
     * Rajoute un Pokemon dans la main du joueur provenant de la pioche, le Pokemon est saisi aleatoirement
     */
    public void ajoutMain() {
        Random r = new Random();
        if(m_piochePrivee.getNombrePokemonDansLaPioche() != 0){
            int randomPokemon = r.nextInt(m_piochePrivee.getNombrePokemonDansLaPioche());
            m_mainPrivee.ajouterDansMain(m_piochePrivee.getPokemonDansLaPioche(randomPokemon));
            m_piochePrivee.removePokemonDansLaPioche(randomPokemon);
        }


    }

    public Main getMain() {
        return m_mainPrivee;
    }

    public Terrain getTerrain() {
        return m_terrainPrivee;
    }
}
