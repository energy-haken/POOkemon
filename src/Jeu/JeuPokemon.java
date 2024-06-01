package Jeu;


import Jeu.Partie.Affichage;
import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Joueur;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Terrain;
import Jeu.Partie.Tour;
import java.util.ArrayList;
import java.util.Random;


public class JeuPokemon {

    public void LancerJeu(){

        ListePouvoirs pouvoirDeLaPartie = new ListePouvoirs() ;

        ArrayList joueur = ordreCreation(pouvoirDeLaPartie) ;

        Adversaire adversaire = (Adversaire) joueur.get(1);
        Utilisateur utilisateur = (Utilisateur) joueur.get(0);


        Affichage affichage = new Affichage() ;
        Terrain terrainAdversaire = adversaire.getTerrain();
        Tour tour = new Tour(utilisateur, adversaire);

        // Ajout des cartes a la main
        Musique.playGameMusic();

        utilisateur.ajoutMain();
        utilisateur.ajoutMain();
        utilisateur.ajoutMain();
        utilisateur.ajoutMain();
        utilisateur.ajoutMain();

        adversaire.ajoutMain();
        adversaire.ajoutMain();
        adversaire.ajoutMain();
        adversaire.ajoutMain();
        adversaire.ajoutMain();

        System.out.println("Lancement du jeu ... \n");

        initTerrain(utilisateur);




        adversaire.getMain().ajoutPokemonSurleTerrain(terrainAdversaire);
        adversaire.getMain().ajoutPokemonSurleTerrain(terrainAdversaire);
        adversaire.getMain().ajoutPokemonSurleTerrain(terrainAdversaire);




        /*
        boolean verif = terrainAdversaire.checkVictoire(adversaire);
        if(verif){
            Musique.stopMusic();
        }

        terrainAdversaire.checkDeath(adversaire);
        */

        while(true){
            affichage.afficheJeu(tour , adversaire, utilisateur );
            CheckJoueur(tour, utilisateur, adversaire);
        }

    }




    public void CheckJoueur(Tour tour, Utilisateur utilisateur, Adversaire adversaire){
        Terrain terrainUtilisateur = utilisateur.getTerrain();
        Terrain terrainAdversaire = adversaire.getTerrain();

        if(verifTourUtilisateur(tour, utilisateur)){
            while(terrainUtilisateur.getNombrePokemonSurTerrain() < 3 && utilisateur.getMain().getNombrePokemonDansLaMain() != 0){
                utilisateur.imputPoserPokemon();
            }
            while(utilisateur.getMain().getNombrePokemonDansLaMain() < 5 && utilisateur.getPiocheJoueur().getNombrePokemonDansLaPioche() != 0){
                utilisateur.ajoutMain();
            }
            for(int i = 0 ; i < utilisateur.getTerrain().getNombrePokemonSurTerrain() ; i++){
                if(utilisateur.getTerrain().getPokemonSurTerrain(i).getPouvoir() != null && utilisateur.getTerrain().getPokemonSurTerrain(i).getPouvoir().getDejaUtiliser() == false){
                    utilisateur.inputUtiliserPouvoir(utilisateur.getTerrain().getPokemonSurTerrain(i), adversaire);
                }
            }
           while(utilisateur.getTerrain().getNombrePokemonDejaAttaquer() != utilisateur.getTerrain().getNombrePokemonSurTerrain()) {

               System.out.println(Affichage.demandeInput("Veuillez choisir quelle Pokémon VA attaquer :"));
                Pokemon pokechoisi = utilisateur.inputUserChoixQuiAttaque(terrainUtilisateur);
               System.out.println(Affichage.demandeInput("Veuillez choisir quelle Pokémon va ETRE attaquer :"));
                Pokemon pokechoisi2 = utilisateur.inputUserChoixQuiSeFaitAttaquer(terrainAdversaire);
                pokechoisi.attaque(pokechoisi2);
           }
        }

        if(verifTourAdversaire(tour, adversaire)){
            for(int i =0 ; i < adversaire.getTerrain().getNombrePokemonSurTerrain() ;i++) {
                adversaire.getTerrain().getPokemonSurTerrain(i).attaque(adversaire.choixOrdrePokemon(utilisateur.getTerrain()));
            }
            while(terrainAdversaire.getNombrePokemonSurTerrain() < 3 && adversaire.getMain().getNombrePokemonDansLaMain() != 0){
                adversaire.getMain().ajoutPokemonSurleTerrain(terrainAdversaire);
            }
            while(adversaire.getMain().getNombrePokemonDansLaMain() < 5 && adversaire.getPiocheJoueur().getNombrePokemonDansLaPioche() != 0){
                adversaire.ajoutMain();
            }
        }
        tour.tourSuivant();
    }



    public boolean verifTourUtilisateur(Tour tour , Utilisateur utilisateur){
        if(tour.getTourDuJoueur() == utilisateur){
            return true ;
        }
        else {
            return false ;
        }
    }

    public boolean verifTourAdversaire(Tour tour ,Adversaire adversaire){
        if(tour.getTourDuJoueur() == adversaire){
            return true ;
        }
        else {
            return false ;
        }
    }

    public void initTerrain(Utilisateur utilisateur){

        while(utilisateur.getTerrain().getNombrePokemonSurTerrain() < 3 && utilisateur.getMain().getNombrePokemonDansLaMain() != 0){
            utilisateur.getMain().afficheMain();
            utilisateur.imputPoserPokemon();
        }
    }

    public ArrayList ordreCreation(ListePouvoirs pouvoirDeLaPartie){
        Random rand = new Random();
        int r = rand.nextInt(2) ;

        ArrayList<Joueur> joueurPartie = new ArrayList<>() ;
        if(r == 0){
            Utilisateur utilisateur = new Utilisateur(pouvoirDeLaPartie);
            Adversaire adversaire = new Adversaire(pouvoirDeLaPartie);

            joueurPartie.add(utilisateur);
            joueurPartie.add(adversaire) ;
            return joueurPartie ;
        }
        if(r == 1){
            Adversaire adversaire = new Adversaire(pouvoirDeLaPartie);
            Utilisateur utilisateur = new Utilisateur(pouvoirDeLaPartie) ;

            joueurPartie.add(utilisateur);
            joueurPartie.add(adversaire) ;
            return joueurPartie ;
        }
        return joueurPartie ;
    }
}
