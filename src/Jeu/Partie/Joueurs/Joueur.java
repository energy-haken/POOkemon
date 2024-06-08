package Jeu.Partie.Joueurs;

import Jeu.Partie.NomPokemon;
import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Pouvoirs.Pouvoir;
import Jeu.Partie.Terrain;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {

    protected ArrayList<Pouvoir> m_pouvoirEnJeu ;
    private Pioche m_piochePrivee;
    private Main m_mainPrivee = new Main();
    private Terrain m_terrainPrivee = new Terrain(this);


    public Joueur(ArrayList pouvoirs){
        m_pouvoirEnJeu = pouvoirs;
        m_piochePrivee = new Pioche(m_pouvoirEnJeu);
    }


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
