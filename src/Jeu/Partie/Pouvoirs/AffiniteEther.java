package Jeu.Partie.Pouvoirs;

import Jeu.Element.Ether;
import Jeu.Partie.Joueurs.Joueur;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Pokemon;

public class AffiniteEther extends Pouvoir{
    private Ether m_type = new Ether() ;
    public AffiniteEther(){
        m_nom = "Affinite Ether"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = false ;
        m_description = "Affinite ether : à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). " +
                        "Le Pokémon change son affinité pour une affinité avec l'Ether. " +
                        "L'Ether est un nouvel élément ayant un avantage sur tous les autres." ;
        m_nbTourActif = 0 ;
    }

    @Override
    public void  utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerType(m_type);
        m_dejaUtiliser = true ;
        m_nom += "(X)" ;


    }
}
