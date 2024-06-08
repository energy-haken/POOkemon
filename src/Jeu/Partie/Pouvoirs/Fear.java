package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class Fear extends Pouvoir{
    public Fear(){
        m_nom = "Peur"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = false ;
        m_description = "Peur : à utilisation unique : le Pokémon choisit un Pokémon du camp adverse. " +
                "Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégats de moins." ;
        m_nbTourActif = 0 ;
        m_cible = 1 ;
    }

    @Override
    public void utiliserLePouvoir(Pokemon pokemon){
        m_dejaUtiliser = true ;
        pokemon.changerPeur(10);
        m_nom += "(X)" ;
    }
}
