package Jeu.Partie.Joueurs;

import Jeu.Partie.NomPokemon;
import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Pouvoirs.Pouvoir;
import Jeu.Pokemon;

import java.util.ArrayList;

public class Pioche {
    private ArrayList<Pokemon> m_pokemonDansLaPioche = new ArrayList<>();
    private int m_nombrePokemonDansLaPioche ;
    private NomPokemon m_nomPokemonQuiReste = new NomPokemon();
    private ListePouvoirs m_pouvoirQuiReste ;

    public Pioche(ListePouvoirs pouvoirs) {
        m_pouvoirQuiReste = pouvoirs;
        genererPioche() ;
        m_nombrePokemonDansLaPioche = m_pokemonDansLaPioche.size();

    }

    public void genererPioche() {
        for (int i = 0; i < 21; i++){
            m_pokemonDansLaPioche.add(new Pokemon(m_nomPokemonQuiReste, m_pouvoirQuiReste));

        }

    }

    public void afficherPioche() {
        for (int i = 0; i < m_pokemonDansLaPioche.size(); i++) {
            System.out.println(m_pokemonDansLaPioche.get(i).toString());
        }

    }

    /**
     *
     * @return le nombre de Pokemons présent dans la Pioche
     */
    public int getNombrePokemonDansLaPioche() {
        return m_nombrePokemonDansLaPioche;
    }

    public Pokemon getPokemonDansLaPioche(int i) {
        return m_pokemonDansLaPioche.get(i);
    }

    public void removePokemonDansLaPioche(int i) {
        m_pokemonDansLaPioche.remove(i);
        m_nombrePokemonDansLaPioche--;
    }


}
