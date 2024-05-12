package Jeu.Partie;

import Jeu.Pokemon;

import java.util.ArrayList;

public class Terrain {

    private ArrayList<Pokemon> m_pokemonSurTerrain = new ArrayList<>();

    public void ajoutPokemonSurTerrainAdversaire(Pokemon pokemon){
        m_pokemonSurTerrain.addFirst(pokemon);
    }

    public void ajoutPokemonSurTerrainUtilisateur(Pokemon pokemon){
        m_pokemonSurTerrain.addLast(pokemon);
    }

    public void afficherTerrain() {
        String ligneAdversaire = "      ***** Adversaire *****" + "\n";
        String ligneRetour = "";
        System.out.println(ligneAdversaire);
        for (int i = 0; i < m_pokemonSurTerrain.size(); i++) {
            ligneRetour += m_pokemonSurTerrain.get(i).toString() + "\n";
            if(i == 2){
                ligneRetour += "--------------------------------------" + "\n" ;
            }

        }
        System.out.println(ligneRetour);
        String ligneUtilisateur = "     ***** Joueur *****" + "\n";
        System.out.println(ligneUtilisateur);

    }

    public void checkDeath() {

        for (int i = 0 ; i < m_pokemonSurTerrain.size(); i++) {
            if (m_pokemonSurTerrain.get(i).getPointDeVie() == 0) {
                System.out.println(m_pokemonSurTerrain.get(i).getNom() + "est KO !") ;
                m_pokemonSurTerrain.remove(i);

            }
        }
    }

    public Pokemon getPokemonSurTerrain(int i) {
        return m_pokemonSurTerrain.get(i) ;
    }
}
