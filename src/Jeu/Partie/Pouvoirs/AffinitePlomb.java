package Jeu.Partie.Pouvoirs;

import Jeu.Element.Affinite;
import Jeu.Element.Plomb;
import Jeu.Pokemon;

public class AffinitePlomb extends Pouvoir{

    private Plomb m_type = new Plomb() ;

    public AffinitePlomb(){
        m_nom = "Affinite Plomb"; ;
        m_reutisable = false ;
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_description = "Affinité Plomb : à utilisation unique : " +
                "le Pokémon choisit un Pokémon adverse. Le Pokémon change son affinité pour une affinité avec le plomb. " +
                "Le Plomb est un nouvel élément sur lequel tous les autres éléments ont un avantage." ;
    }

    @Override
    public void  utiliserLePouvoir(Pokemon pokemon){
        pokemon.changerType(m_type);
        m_dejaUtiliser = true ;
        m_nom += "(X)" ;



    }





}
