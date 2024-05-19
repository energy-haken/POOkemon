package Jeu.Partie;

import Jeu.Musique;
import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Joueur;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Pokemon;


import java.util.ArrayList;

public class Terrain {

    private ArrayList<Pokemon> m_pokemonSurTerrain = new ArrayList<>();
    private Defausse m_defausseJoueur = new Defausse();
    private Joueur m_joueurAssocier ;
    private ArrayList<Pokemon> m_aDejaAttaquer = new ArrayList<>();

    public Terrain(Joueur joueur) {
        m_joueurAssocier = joueur;
    }

    /**
     * Ajoute un Pokemon sur le Terrain du coté de l'adversaire
     * @param pokemon Un pokémon
     */
    public void ajoutPokemonSurTerrain(Pokemon pokemon){
        m_pokemonSurTerrain.add(pokemon);
    }



    public void afficherTerrain() {

        for(int i = 0; i < m_pokemonSurTerrain.size(); i++) {
            System.out.println((i+1) + " : " + m_pokemonSurTerrain.get(i).toString());
        }
    }

    public void removePokemonSurTerrain(int i)
    {
        m_pokemonSurTerrain.remove(i);
    }

    public void checkDeath(Utilisateur utilisateur) {
        for (int i = 0 ; i < utilisateur.getTerrain().getNombrePokemonSurTerrain(); i++) {
            if (utilisateur.getTerrain().getPokemonSurTerrain(i).getPointDeVie() <= 0) {
                Musique.playMusic("src/Jeu/Sons/deathSound.WAV");
                System.out.println(utilisateur.getTerrain().getPokemonSurTerrain(i).getNom() + " est KO !") ;
                utilisateur.getTerrain().getDefausseJoueur().ajoutPokemonDefausse(utilisateur.getTerrain().getPokemonSurTerrain(i));
                utilisateur.getTerrain().removePokemonSurTerrain(i);


            }
        }

        if (utilisateur.getTerrain().getNombrePokemonSurTerrain() == 0 && utilisateur.getTerrain().getDefausseJoueur().getNombrePokemonDansDefausse() > 1 && m_joueurAssocier == utilisateur) {
            new GameOver();
        }


    }

    public void checkDeath(Adversaire adversaire) {
        for (int i = 0 ; i < adversaire.getTerrain().getNombrePokemonSurTerrain(); i++) {
            if (adversaire.getTerrain().getPokemonSurTerrain(i).getPointDeVie() <= 0) {
                Musique.playMusic("src/Jeu/Sons/deathSound.WAV");
                System.out.println(adversaire.getTerrain().getPokemonSurTerrain(i).getNom() + " est KO !") ;
                adversaire.getTerrain().getDefausseJoueur().ajoutPokemonDefausse(adversaire.getTerrain().getPokemonSurTerrain(i));
                adversaire.getTerrain().removePokemonSurTerrain(i);


            }
        }

        if (adversaire.getTerrain().getNombrePokemonSurTerrain() == 0 && adversaire.getTerrain().getDefausseJoueur().getNombrePokemonDansDefausse() > 1 && m_joueurAssocier == adversaire) {
            Musique.playMusic("src/Jeu/Sons/VictorySound.WAV");
            new Victoire();
        }


    }

    public Pokemon getPokemonSurTerrain(int i) {
        return m_pokemonSurTerrain.get(i) ;
    }

    public Defausse getDefausseJoueur() {
        return m_defausseJoueur;
    }

    public int getNombrePokemonSurTerrain() {
        return m_pokemonSurTerrain.size();
    }

    public void ajouterPokemonDejaAttaquer(Pokemon pokemon) {
        m_aDejaAttaquer.add(pokemon);
    }
   public void viderPokemonQuiAJouer(){
        m_aDejaAttaquer.clear();
   }

   public int getNombrePokemonDejaAttaquer(){
        return m_aDejaAttaquer.size();
   }

   public Pokemon getPokemonDejaAttaquer(int i) {
        return m_aDejaAttaquer.get(i);
   }


}
