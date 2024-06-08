package Jeu.Partie.Pouvoirs;

import Jeu.Partie.Affichage;
import Jeu.Partie.Joueurs.Joueur;
import Jeu.Partie.Terrain;
import Jeu.Pokemon;
import Jeu.Partie.Pouvoirs.* ;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class Pouvoir {
    protected Boolean m_dejaUtiliser ;
    protected Boolean m_dejaDistribuer ;
    protected String m_nom ;
    protected String m_description ;
    protected Boolean m_reutisable ;
 //   protected Joueur m_joueurAssocier ;
    protected int m_nbTourActif ;
    protected int m_nbTourActifInitial ;
    protected Pokemon m_pokemonAssocier ;
    protected int m_cible ;





    public void utiliserLePouvoir(Pokemon pokemon){
        m_dejaUtiliser  = true ;
    }

    public void regenerPouvoir(Pokemon pokemon){
        m_dejaUtiliser  = false ;
        m_nbTourActif = m_nbTourActifInitial ;
    }

    public String getDescription(){
        return m_description;
    }

    public String getNom(){
        return m_nom;
    }

    public Boolean getDejaUtiliser(){
        return m_dejaUtiliser;
    }

    public Boolean getDejaDistribuer(){
        return m_dejaDistribuer;
    }

    public boolean getReutisable(){
        return m_reutisable;
    }

    public void distribuer(){
        m_dejaDistribuer = true ;
    }

    public int getNbTourActif(){
        return m_nbTourActif ;
    }

    public void changerTourActif(int i){
        m_nbTourActif = i ;
    }

    public void remiseA0(){

    }

    public void reutiliser(){
        m_dejaUtiliser = false ;
    }

    public int getCible(){
        return m_cible ;
    }


}
