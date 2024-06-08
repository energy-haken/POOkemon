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
        for (int i = 0; i < terrain.getNombrePokemonSurTerrain(); i++) {
            for (int j = 0; j < this.getTerrain().getNombrePokemonSurTerrain(); j++) {
                if (terrain.getPokemonSurTerrain(i).getType().getNom() == this.getTerrain().getPokemonSurTerrain(0).getType().getAvantage()){
                    m_ordreAttaque = terrain.getPokemonSurTerrain(i);
                    return m_ordreAttaque;

                }
                else {
                    if (terrain.getPokemonSurTerrain(i).getPointDeVie() < this.getTerrain().getPokemonSurTerrain(0).getPointDeVie()) {
                        m_ordreAttaque = terrain.getPokemonSurTerrain(i);
                        return m_ordreAttaque;
                    }
                    else {
                        Random rand = new Random();
                        int index = rand.nextInt(this.getTerrain().getNombrePokemonSurTerrain());
                        m_ordreAttaque = terrain.getPokemonSurTerrain(index);
                    }
                }
            }
        }
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
