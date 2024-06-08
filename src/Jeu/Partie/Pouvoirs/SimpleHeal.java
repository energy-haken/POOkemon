package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class SimpleHeal extends Pouvoir{
    public SimpleHeal(){
        m_nom = "Soin simple"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = true ;
        m_description = "Soin simple : utilisable à chaque tour : " +
                "le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). " +
                "Celui-ci regagne 30 points de vie (mais ne peut pas dépasser son nombre de points de vie initial)." ;
        m_nbTourActif = 0 ;
        m_cible = 0 ;
    }

    @Override
    public void utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerVie(pokemon.getPointDeVie() + 30); ;
        m_dejaUtiliser = true ;

    }
}
