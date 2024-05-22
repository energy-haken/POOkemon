package Jeu.Partie.Joueurs;

import Jeu.Partie.Terrain;
import Jeu.Pokemon;


import java.util.Scanner;

public class Utilisateur extends Joueur {



    public Pokemon inputUserChoixQuiAttaque(Terrain terrain) {

        String chaine = "";
        Pokemon pokemonchoisi;
        for (int j = 0; j < terrain.getNombrePokemonSurTerrain(); j++) {

            chaine += " " + (j + 1) + " ";
        }
        System.out.println("Quel Pokemon voulez vous choisir ? (" + chaine + ")");
        firstloop :
        while (true) {
            Scanner s = new Scanner(System.in);
            if (!s.hasNextInt()) {
                System.out.println("Erreur, veuillez choisir un nombre.");
            }
            else {
                int i = s.nextInt();

                if (i > terrain.getNombrePokemonSurTerrain() || i < 1) {
                    System.out.println("Erreur, veuillez choisir un nombre correct.");
                }

                else if(!this.checkAttackValide(i , terrain)){
                    System.out.println("Erreur");
                }

                else {

                    pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
                    terrain.ajouterPokemonDejaAttaquer(pokemonchoisi);
                    break ;


                }
            }
        }
            return pokemonchoisi;
        }


    public boolean checkAttackValide(int i, Terrain terrain){
        Pokemon pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
        boolean attaqueValide = false ;
        for(int j = 0; terrain.getNombrePokemonDejaAttaquer() < i; j++){


            if(terrain.getNombrePokemonDejaAttaquer() != 0 && pokemonchoisi == terrain.getPokemonDejaAttaquer(j)){
                attaqueValide = false;
                return attaqueValide;
            }
            else{
                attaqueValide = true;
                return attaqueValide;
            }
        }
        return attaqueValide;
    }

    public Pokemon inputUserChoixQuiSeFaitAttaquer(Terrain terrain){
        String chaine = "" ;
        Pokemon pokemonchoisi;
        for(int j = 0 ; j < terrain.getNombrePokemonSurTerrain() ; j++ ){

            chaine += " " + (j+1) + " " ;
        }
        System.out.println("Quel Pokemon voulez vous choisir ? ("+ chaine + ")");
        while(true){
            Scanner s= new Scanner(System.in);
            if(!s.hasNextInt()){
                System.out.println("Erreur, veuillez choisir un nombre.");
            }
            else {
                int i = s.nextInt();
                if(i > terrain.getNombrePokemonSurTerrain() || i < 1) {
                    System.out.println("Erreur, veuillez choisir un nombre correct.");
                }

                else {
                    pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
                    for(int j = 0 ; j < terrain.getNombrePokemonDejaAttaquer() ; j++){
                        if(pokemonchoisi == terrain.getPokemonDejaAttaquer(j));{
                            System.out.println("Vous avez deja Attaquer avec ce Pokemon");
                        }
                    }
                    terrain.ajouterPokemonDejaAttaquer(pokemonchoisi);
                    break;

                }
            }

        }

        return pokemonchoisi ;
    }









    public void imputPoserPokemon(){
        String chaine = "" ;
        Pokemon pokemonchoisi;
        for(int j = 0; j < this.getMain().getNombrePokemonDansLaMain() ; j++ ){

            chaine += " " + (j+1) + " " ;
        }
        System.out.println("Quel Pokemon voulez vous posez sur le Terrain ? ("+ chaine + ")");
        while(true){
            Scanner s= new Scanner(System.in);
            if(!s.hasNextInt()){
                System.out.println("Erreur, veuillez choisir un nombre.");
            }
            else {
                int i = s.nextInt();
                if(i > this.getMain().getNombrePokemonDansLaMain() || i < 1) {
                    System.out.println("Erreur, veuillez choisir un nombre correct.");
                }
                else {
                    pokemonchoisi = this.getMain().getPokemonDansLaMain(i - 1);
                    this.getMain().retirerPokemonDansLaMain(i -1);
                    break;
                }
            }

        }

        this.getTerrain().ajoutPokemonSurTerrain(pokemonchoisi);

    }
}
