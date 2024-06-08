package Jeu.Partie;

import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Utilisateur ;

public  class Affichage{



    public void afficherTerrain(Terrain terrain) {

        for (int i = 0; i < terrain.getNombrePokemonSurTerrain(); i++) {
            System.out.println((i + 1) + " : " + terrain.getPokemonSurTerrain(i).toString());
        }
    }

    public String afficheJeu(Tour tour, Adversaire adversaire, Utilisateur utilisateur) {
        Terrain terrainUtilisateur = utilisateur.getTerrain();
        Terrain terrainAdversaire = adversaire.getTerrain();

        String ligneDeRetour = "" ;

        terrainUtilisateur.checkDeath(utilisateur);
        terrainAdversaire.checkDeath(adversaire);

        System.out.println("-------------------------------");
        System.out.println("Tour n" + tour.getNombreDeTour());
        System.out.println(afficheTourAdversaire(tour, adversaire));
        System.out.println(afficheTourUtilisateur(tour,utilisateur));
        System.out.println("-------------------------------");


        System.out.println("    ********Adversaire********");
        System.out.println("Defausse : " + terrainAdversaire.getDefausseJoueur().getNombrePokemonDansDefausse());
        System.out.println("Pioche : " + adversaire.getPiocheJoueur().getNombrePokemonDansLaPioche());
        System.out.println("Main : " + adversaire.getMain().getNombrePokemonDansLaMain() + "\n");
        afficherTerrain(terrainAdversaire);
        System.out.println("--------------------------------------");
        afficherTerrain(terrainUtilisateur);
        System.out.println();
        System.out.println("Defausse : " + terrainUtilisateur.getDefausseJoueur().getNombrePokemonDansDefausse());
        System.out.println("Pioche : " + utilisateur.getPiocheJoueur().getNombrePokemonDansLaPioche());
        System.out.println("En main : ");
        utilisateur.getMain().afficheMain();
        System.out.println("    ********Utilisateur**********" + "\n");

        return ligneDeRetour ;
    }

    public String afficheTourUtilisateur(Tour tour , Utilisateur utilisateur){
        if(tour.getTourDuJoueur() == utilisateur){

            return "C'est votre tour de jouer !";

        }
        else{
            return "" ;
        }
    }

    public String afficheTourAdversaire(Tour tour ,Adversaire adversaire){
        if(tour.getTourDuJoueur() == adversaire){
            return "C'est au tour de l'adversaire !" ;

        }
        else{
            return "" ;
        }
    }

    public static String demandeInput(String question){
        String ligne = "o" ;
        String demande = "| "+ question + " |";

        for(int i = 0 ;  ligne.length() < demande.length() - 1  ; i++)
        {
            ligne += "-" ;
        }
        ligne += "o" ;

        return ligne + "\n" + demande + "\n" + ligne ;
    }
}