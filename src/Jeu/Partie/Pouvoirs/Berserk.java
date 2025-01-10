package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class Berserk extends Pouvoir{

    public Berserk(){
        m_nom = "Berserk"; ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_reutisable = false ;
        m_description = "Berserk : à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). " +
                "Pour le tour en cours, l'attaque de ce Pokémon est doublée." ;
        m_nbTourActif = 1 ;
        m_cible = 0 ;

    }

    @Override
    public void utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerAttaque(pokemon.getAttaque() * 2) ;
        m_dejaUtiliser = true ;
        m_nom += "(X)" ;

        m_pokemonAssocier = pokemon ;
    }

    @Override
    public void remiseA0(){
        m_pokemonAssocier.changerAttaque(m_pokemonAssocier.getAttaque() /2);
    }





}
