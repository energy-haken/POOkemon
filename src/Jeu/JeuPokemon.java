package Jeu;


import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Partie.Terrain;
import Jeu.Partie.Tour;


public class JeuPokemon {

    public void LancerJeu(){



        Utilisateur utilisateur = new Utilisateur();
        Adversaire adversaire = new Adversaire();
        Terrain terrainUtilisateur = utilisateur.getTerrain();
        Terrain terrainAdversaire = adversaire.getTerrain();
        Tour tour = new Tour(utilisateur, adversaire);

        // Ajout des cartes a la main
        Musique.playMusic("src/Jeu/Sons/BattleMusic.wav");

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

        while(true){
            afficheJeu(tour , adversaire, utilisateur );
        }









    }

    public void afficheJeu(Tour tour , Adversaire adversaire, Utilisateur utilisateur) {
        Terrain terrainUtilisateur = utilisateur.getTerrain();
        Terrain terrainAdversaire = adversaire.getTerrain();

        terrainUtilisateur.checkDeath(utilisateur);
        terrainAdversaire.checkDeath(adversaire);
        System.out.println("-------------------------------") ;
        System.out.println("Tour n" + tour.getNombreDeTour());
        afficheTourUtilisateur(tour , utilisateur);
        afficheTourAdversaire(tour, adversaire);
        System.out.println("-------------------------------");


        System.out.println("    ********Adversaire********");
        System.out.println("Defausse : " + terrainAdversaire.getDefausseJoueur().getNombrePokemonDansDefausse());
        System.out.println("Pioche : " + adversaire.getPiocheJoueur().getNombrePokemonDansLaPioche()) ;
        System.out.println("Main : " + adversaire.getMain().getNombrePokemonDansLaMain() + "\n");
        terrainAdversaire.afficherTerrain();
        System.out.println("--------------------------------------");
        terrainUtilisateur.afficherTerrain();
        System.out.println() ;
        System.out.println("Defausse : " + terrainUtilisateur.getDefausseJoueur().getNombrePokemonDansDefausse() ) ;
        System.out.println("Pioche : " + utilisateur.getPiocheJoueur().getNombrePokemonDansLaPioche()) ;
        System.out.println("En main : ") ;
        utilisateur.getMain().afficheMain() ;
        System.out.println("    ********Utilisateur**********" + "\n");




        if(verifTourUtilisateur(tour, utilisateur)){
            while(terrainUtilisateur.getNombrePokemonSurTerrain() < 3 && utilisateur.getMain().getNombrePokemonDansLaMain() != 0){
                utilisateur.imputPoserPokemon();
            }
            while(utilisateur.getMain().getNombrePokemonDansLaMain() < 5 && utilisateur.getPiocheJoueur().getNombrePokemonDansLaPioche() != 0){
                utilisateur.ajoutMain();
            }
           while(utilisateur.getTerrain().getNombrePokemonDejaAttaquer() != utilisateur.getTerrain().getNombrePokemonSurTerrain()) {
                System.out.println("Veuillez choisir quelle Pokémon va attaquer :");
                Pokemon pokechoisi = utilisateur.inputUserChoixQuiAttaque(terrainUtilisateur);
                System.out.println("Veuillez choisir quelle Pokémon va être attaquer : ");
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

    public void afficheTourUtilisateur(Tour tour , Utilisateur utilisateur){
        if(tour.getTourDuJoueur() == utilisateur){
            System.out.println("C'est votre tour de jouer !") ;

        }
    }

    public void afficheTourAdversaire(Tour tour ,Adversaire adversaire){
        if(tour.getTourDuJoueur() == adversaire){
            System.out.println("C'est au tour de l'adversaire !\"") ;

        }
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
}
