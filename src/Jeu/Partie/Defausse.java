package Jeu.Partie;

import Jeu.Pokemon;

import java.util.ArrayList;

public class Defausse {
    private ArrayList<Pokemon> m_pokemonDansLaDefausse = new ArrayList<>();
    private int m_nombrePokemonDansDefausse ;

    public Defausse() {
        m_nombrePokemonDansDefausse = m_pokemonDansLaDefausse.size();
    }
    public void ajoutPokemonDefausse(Pokemon pokemon){
        m_pokemonDansLaDefausse.add(pokemon);
        m_nombrePokemonDansDefausse += 1 ;
    }

    public String afficheDefausse(){
        return m_pokemonDansLaDefausse.toString() ;
    }

    public int getNombrePokemonDansDefausse() {
        return m_nombrePokemonDansDefausse;
    }
}
