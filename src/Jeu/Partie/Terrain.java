package Jeu.Partie;

import Jeu.Musique;
import Jeu.Partie.Joueurs.Adversaire;
import Jeu.Partie.Joueurs.Joueur;
import Jeu.Partie.Joueurs.Utilisateur;
import Jeu.Pokemon;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Terrain {

    protected ArrayList<Pokemon> m_pokemonSurTerrain = new ArrayList<>();
    protected Defausse m_defausseJoueur = new Defausse();
    protected Joueur m_joueurAssocier ;
    protected ArrayList<Pokemon> m_aDejaAttaquer = new ArrayList<>();


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

        if (checkVictoire(adversaire) == true){
            Musique.playMusic("src/Jeu/Sons/VictorySound.WAV");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            new Victoire();
        }


    }

    public boolean checkVictoire(Adversaire adversaire){
        if (adversaire.getTerrain().getNombrePokemonSurTerrain() == 0 && adversaire.getTerrain().getDefausseJoueur().getNombrePokemonDansDefausse() > 1 && m_joueurAssocier == adversaire) {
            return true ;
        }
        else{
            return false ;
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
