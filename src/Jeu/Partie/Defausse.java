package Jeu.Partie;

import Jeu.Pokemon;

import java.util.ArrayList;

public class Defausse {
    private ArrayList<Pokemon> m_pokemonDansLaDefausse = new ArrayList<>();

    public void ajoutPokemonDefausse(Pokemon pokemon){
        m_pokemonDansLaDefausse.add(pokemon);
    }

    public String afficheDefausse(){
        return m_pokemonDansLaDefausse.toString() ;
    }
}
