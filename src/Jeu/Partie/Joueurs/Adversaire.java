package Jeu.Partie.Joueurs;

import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Pouvoirs.Pouvoir;
import Jeu.Partie.Terrain;
import Jeu.Pokemon ;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Adversaire extends Joueur {
    private Pokemon m_ordreAttaque;

    public Adversaire(ArrayList pouvoirsEnJeu) {
        super(pouvoirsEnJeu);
    }

    public Pokemon choixOrdrePokemon(Terrain terrain) {
        // Parcourir les Pokémon sur le terrain adverse
        for (int i = 0; i < terrain.getNombrePokemonSurTerrain(); i++) {
            Pokemon adversaire = terrain.getPokemonSurTerrain(i);

            // Comparer le type du Pokémon adverse avec l'avantage du type de votre premier Pokémon
            if (adversaire.getType().getNom().equals(this.getTerrain().getPokemonSurTerrain(0).getType().getAvantage())) {
                m_ordreAttaque = adversaire;
                return m_ordreAttaque;
            }
        }

        // Si aucun Pokémon n'a un type avec avantage, trouver le Pokémon avec le moins de points de vie
        Pokemon moinsPointsDeVie = null;
        for (int i = 0; i < terrain.getNombrePokemonSurTerrain(); i++) {
            Pokemon adversaire = terrain.getPokemonSurTerrain(i);
            if (moinsPointsDeVie == null || adversaire.getPointDeVie() < moinsPointsDeVie.getPointDeVie()) {
                moinsPointsDeVie = adversaire;
            }
        }

        // Si un Pokémon avec moins de points de vie est trouvé, le choisir
        if (moinsPointsDeVie != null && moinsPointsDeVie.getPointDeVie() < this.getTerrain().getPokemonSurTerrain(0).getPointDeVie()) {
            m_ordreAttaque = moinsPointsDeVie;
            return m_ordreAttaque;
        }

        // Sinon, choisir un Pokémon aléatoirement
        Random rand = new Random();
        int index = rand.nextInt(terrain.getNombrePokemonSurTerrain());
        m_ordreAttaque = terrain.getPokemonSurTerrain(index);

        return m_ordreAttaque;
    }


    public void utilisationPouvoir(Terrain terrain) {
        for (int i = 0; i < this.getTerrain().getNombrePokemonSurTerrain(); i++) {
            Pokemon pokeUtil = this.getTerrain().getPokemonSurTerrain(i);
            if (pokeUtil.getPouvoir() != null && !pokeUtil.getPouvoir().getDejaUtiliser()) {
                if (pokeUtil.getPouvoir().getCible() == 1) {
                        pokeUtil.utiliserPouvoir(terrain.getPokemonSurTerrain(0));
                }
                else if (pokeUtil.getPouvoir().getCible() == 0) {
                        pokeUtil.utiliserPouvoir(this.getTerrain().getPokemonSurTerrain(0));
                }
            }
        }
    }
}
