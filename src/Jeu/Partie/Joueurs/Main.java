package Jeu.Partie.Joueurs;

import Jeu.Partie.Terrain;
import Jeu.Pokemon;

import java.util.ArrayList;

public class Main {
    private ArrayList<Pokemon> m_pokemonDansLaMain = new ArrayList<>();


    public void ajouterDansMain(Pokemon p){
        m_pokemonDansLaMain.add(p);
    }

    public void ajoutPokemonSurleTerrainAdversaire(Terrain terrain){
        terrain.ajoutPokemonSurTerrainAdversaire(m_pokemonDansLaMain.getFirst()); //Valeur a changer
        m_pokemonDansLaMain.removeFirst();
    }

    public void ajoutPokemonSurleTerrainUtilisateur(Terrain terrain){
        terrain.ajoutPokemonSurTerrainUtilisateur(m_pokemonDansLaMain.getFirst()); //Valeur a changer
        m_pokemonDansLaMain.removeFirst();
    }
}
