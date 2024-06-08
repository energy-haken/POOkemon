package Jeu.Partie.Pouvoirs;

import Jeu.Pokemon;

public class Regeneration extends Pouvoir {
    public Regeneration() {
        m_nom = "Regeneration";
        ;
        m_dejaDistribuer = false;
        m_dejaUtiliser = false;
        m_reutisable = false;
        m_description = "Regeneration : à utilisation unique : " +
                "le Pokémon choisit un Pokémon de son camp. Si le Pokémon a déjà utilisé un pouvoir à utilisation unique, il peut alors l'utiliser une seconde fois.";
        m_nbTourActif = 0;
        m_cible = 0 ;
    }

    @Override
    public void utiliserLePouvoir(Pokemon pokemon){
        if(pokemon.getPouvoir() != null){
            pokemon.getPouvoir().reutiliser();
            m_dejaUtiliser = true ;
            m_nom += "(X)" ;
        }
        else{
            System.out.println(pokemon.getNom() + " n'avait pas de pouvoir !");
            m_dejaUtiliser = true ;
            m_nom += "(X)" ;
        }

    }
}
