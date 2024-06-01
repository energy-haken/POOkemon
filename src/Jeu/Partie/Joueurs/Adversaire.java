package Jeu.Partie.Joueurs;

import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Pouvoirs.Pouvoir;
import Jeu.Partie.Terrain;
import Jeu.Pokemon ;

import java.util.Objects;
import java.util.Random;

public class Adversaire extends Joueur {
    private Pokemon m_ordreAttaque ;

    public Adversaire(ListePouvoirs pouvoirsEnJeu){
        super(pouvoirsEnJeu) ;
    }

    public Pokemon choixOrdrePokemon(Terrain terrain){
       for(int i = 0 ; i < terrain.getNombrePokemonSurTerrain() ; i++){
           for(int j = 0 ; j < this.getTerrain().getNombrePokemonSurTerrain() ; j++)
           {
               if(Objects.equals(terrain.getPokemonSurTerrain(i).getType().getNom(), this.getTerrain().getPokemonSurTerrain(0).getType().getAvantage())){
                    m_ordreAttaque = terrain.getPokemonSurTerrain(i);
                    return m_ordreAttaque ;

               }
               else{
                   if(terrain.getPokemonSurTerrain(i).getPointDeVie() < this.getTerrain().getPokemonSurTerrain(0).getPointDeVie()){
                       m_ordreAttaque = terrain.getPokemonSurTerrain(i);
                       return m_ordreAttaque;
                   }
                   else{
                       Random rand = new Random();
                       int index = rand.nextInt(this.getTerrain().getNombrePokemonSurTerrain());
                       m_ordreAttaque = terrain.getPokemonSurTerrain(index);
                   }
               }
           }
       }
       return m_ordreAttaque ;
    }
}
