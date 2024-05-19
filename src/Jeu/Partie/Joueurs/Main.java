package Jeu.Partie.Joueurs;

import Jeu.Partie.Terrain;
import Jeu.Pokemon;

import java.util.ArrayList;

public class Main {
    private ArrayList<Pokemon> m_pokemonDansLaMain = new ArrayList<>();
    private int m_nombrePokemonDansLaMain ;

    public Main() {
        m_nombrePokemonDansLaMain = m_pokemonDansLaMain.size() ;
    }

    /**
     * Ajoute un pokémon dans la main
     * @param p Un Pokémon
     */


    public void ajouterDansMain(Pokemon p){
        m_pokemonDansLaMain.add(p);
        m_nombrePokemonDansLaMain += 1 ;
    }

    /**
     * Ajoute un Pokemon sur le terrain coté Adversaire
     * @param terrain le terrain sur lequel le jeu se déroule
     */
    public void ajoutPokemonSurleTerrain(Terrain terrain){
        terrain.ajoutPokemonSurTerrain(m_pokemonDansLaMain.getFirst());
        m_pokemonDansLaMain.removeFirst();
        m_nombrePokemonDansLaMain -= 1 ;
    }



    /**
     * Affiche la main du Joueur
     */
    public void afficheMain(){
        for(int i = 0 ; i < m_nombrePokemonDansLaMain ; i++){
            System.out.println((i+1) + " : " + m_pokemonDansLaMain.get(i).toString());
        }
    }

    public int getNombrePokemonDansLaMain() {
        return m_nombrePokemonDansLaMain;
    }

    public Pokemon getPokemonDansLaMain(int i) {
        return m_pokemonDansLaMain.get(i);
    }

    public void retirerPokemonDansLaMain(int i) {
        m_pokemonDansLaMain.remove(i);
        m_nombrePokemonDansLaMain -= 1 ;
    }
}
