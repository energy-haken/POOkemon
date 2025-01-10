package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class TotalHeal extends Pouvoir{
    public TotalHeal(){
        m_nom = "Soin Total"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = false ;
        m_description = "Soin total : à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Celui-ci regagne toute sa vie." ;
        m_nbTourActif = 0 ;
        m_cible = 0 ;
    }

    @Override
    public void utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerVie(pokemon.getMaxVie()); ;
        m_dejaUtiliser = true ;
        m_nom += "(X)" ;
    }
}
