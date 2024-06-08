package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class Resistance extends Pouvoir{
    public Resistance(){
        m_nom = "Affinite Ether"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = false ;
        m_description = "Résistance : à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). " +
                "Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, à chaque attaque reçue celui-ci subit subit 10 dégâts de moins." ;
        m_nbTourActif = 0 ;
    }

    @Override
    public void  utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerResitance(10);
        m_dejaUtiliser = true ;
        m_nom += "(X)" ;


    }
}
