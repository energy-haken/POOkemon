import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Partie.Terrain;

public class JeuPP
{

  public static void main(String args[])
  {

    Terrain terrain = new Terrain();
    Utilisateur utilisateur = new Utilisateur();
    Adversaire adversaire = new Adversaire();

    // Ajout des cartes a la main


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

    utilisateur.getMainPrivee().ajoutPokemonSurleTerrainUtilisateur(terrain);
    utilisateur.getMainPrivee().ajoutPokemonSurleTerrainUtilisateur(terrain);
    utilisateur.getMainPrivee().ajoutPokemonSurleTerrainUtilisateur(terrain);

    adversaire.getMainPrivee().ajoutPokemonSurleTerrainAdversaire(terrain);
    adversaire.getMainPrivee().ajoutPokemonSurleTerrainAdversaire(terrain);
    adversaire.getMainPrivee().ajoutPokemonSurleTerrainAdversaire(terrain);

    terrain.afficherTerrain();

    /*
    terrain.getPokemonSurTerrain(4).attaque(terrain.getPokemonSurTerrain(0));
    terrain.checkDeath();
    System.out.println(terrain.getPokemonSurTerrain(0).toString()) ;



    terrain.afficherTerrain();

    */




  }
}
