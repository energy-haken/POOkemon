package Jeu.Partie;


import Jeu.Partie.Joueurs.*;
import Jeu.Partie.Pouvoirs.Pouvoir;

import java.util.ArrayList;
import java.util.Random;

public class Tour {
    private Joueur m_tourDuJoueur ;
    private int m_nombreDeTour = 1 ;
    private ArrayList<Joueur> m_joueurDansLaPartie = new ArrayList<>() ;
    private int m_indexTourDuJoueur = 0 ;

    Random random = new Random();
    int randomTour = random.nextInt(2) ;

    public Tour(Joueur joueur1 , Joueur joueur2){
        switch(randomTour){
            case 0:
                m_tourDuJoueur = joueur1;
                break ;
            case 1:
                m_tourDuJoueur = joueur2;
                break ;
        }
        m_joueurDansLaPartie.add(joueur1) ;
        m_joueurDansLaPartie.add(joueur2) ;
    }


    public void tourSuivant(){
        m_nombreDeTour += 1 ;
        m_tourDuJoueur.getTerrain().viderPokemonQuiAJouer();
        for(int i = 0 ; i < m_tourDuJoueur.getTerrain().getNombrePokemonSurTerrain() ; i++){
            Pouvoir pouvoirDuPoke = m_tourDuJoueur.getTerrain().getPokemonSurTerrain(i).getPouvoir();

            if(pouvoirDuPoke != null){
                if(pouvoirDuPoke.getReutisable()){
                    pouvoirDuPoke.regenerPouvoir(m_tourDuJoueur.getTerrain().getPokemonSurTerrain(i));
                }
            }
        }


        while(m_tourDuJoueur != m_joueurDansLaPartie.get(m_indexTourDuJoueur)){
            m_indexTourDuJoueur += 1 ;
        }
        Joueur dernierJoueur = m_joueurDansLaPartie.getLast() ;
        if(dernierJoueur == m_joueurDansLaPartie.get(m_indexTourDuJoueur)){
            m_indexTourDuJoueur= 0 ;
            m_tourDuJoueur = m_joueurDansLaPartie.get(m_indexTourDuJoueur) ;
        }
        else{
            m_tourDuJoueur = m_joueurDansLaPartie.get(m_indexTourDuJoueur + 1) ;
        }





    }

    public int getNombreDeTour(){
        return m_nombreDeTour ;
    }

    public Joueur getTourDuJoueur(){
        return m_tourDuJoueur ;
    }

}
