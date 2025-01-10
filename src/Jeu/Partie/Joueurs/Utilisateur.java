package Jeu.Partie.Joueurs;

import Jeu.Partie.Affichage;
import Jeu.Partie.Input;
import Jeu.Partie.Terrain;
import Jeu.Pokemon;


import java.util.ArrayList;
import java.util.Scanner;

public class Utilisateur extends Joueur {

    public Utilisateur(ArrayList pouvoirs) {
        super(pouvoirs);
    }

    public Pokemon inputUserChoixQuiAttaque(Terrain terrain) {

        String chaine = "";
        Pokemon pokemonchoisi;
        for (int j = 0; j < terrain.getNombrePokemonSurTerrain(); j++) {

            chaine += " " + (j + 1) + " ";
        }
        System.out.println(Affichage.demandeInput("Quel Pokemon voulez vous choisir ? (" + chaine + ")"));
        for(int j = 0 ; j < terrain.getNombrePokemonSurTerrain() ; j++){
            System.out.println(j+1 + " : "+ terrain.getPokemonSurTerrain(j).toString());
        }
        while (true) {

            int i = Input.InputChiffre();
                if (i > terrain.getNombrePokemonSurTerrain() || i < 1) {
                    System.out.println("Erreur, veuillez choisir un nombre correct.");
                }

                else if(!this.checkAttackValide(i , terrain)){
                    System.out.println("Erreur, vous avez déja attaquer avec ce Pokemon.");
                }

                else {

                    pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
                    terrain.ajouterPokemonDejaAttaquer(pokemonchoisi);
                    break ;


                }
            }

            return pokemonchoisi;
        }


    public boolean checkAttackValide(int i, Terrain terrain){
        Pokemon pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
        boolean attaqueValide = true ;
        for(int j = 0; j < terrain.getNombrePokemonDejaAttaquer(); j++){


            if(terrain.getNombrePokemonDejaAttaquer() != 0 && pokemonchoisi == terrain.getPokemonDejaAttaquer(j)){
                attaqueValide = false;
                return attaqueValide;
            }
            else{
                attaqueValide = true;
                return attaqueValide;
            }
        }
        return attaqueValide ;
    }

    public Pokemon inputUserChoixQuiSeFaitAttaquer(Terrain terrain){
        String chaine = "" ;
        Pokemon pokemonchoisi;
        for(int j = 0 ; j < terrain.getNombrePokemonSurTerrain() ; j++ ){

            chaine += " " + (j+1) + " " ;
        }

        System.out.println(Affichage.demandeInput("Quel Pokemon voulez vous choisir ? (" + chaine + ")"));
        for(int j = 0 ; j < terrain.getNombrePokemonSurTerrain() ; j++){
            System.out.println(j+1 + " : "+ terrain.getPokemonSurTerrain(j).toString());
        }
        while(true){

            int i = Input.InputChiffre();
                if(i > terrain.getNombrePokemonSurTerrain() || i < 1) {
                    System.out.println("Erreur, veuillez choisir un nombre correct.");
                }

                else {
                    pokemonchoisi = terrain.getPokemonSurTerrain(i - 1);
                    break;

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
        System.out.println(Affichage.demandeInput("Quel Pokemon voulez vous posez sur le Terrain ? ("+ chaine + ")"));
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

    /*
    public void inputUtiliserPouvoir(Pokemon pokemon , Adversaire adversaire){

        Pokemon pokemonChoisi ;
        while(true){
            int i = Input.InputChiffre();
            if(i == 1){
                System.out.println("Qui va subir le pouvoir ? (1 = Vous même | 2 = Adversaire)");
                int j = Input.InputChiffre() ;
                if(j == 1){

                    System.out.println("Quel Pokemon va subir le pouvoir ?");

                    for(int h = 0 ; h < this.getTerrain().getNombrePokemonSurTerrain() ; h++){
                        System.out.println(h+1 + " : "+ this.getTerrain().getPokemonSurTerrain(j).toString());
                   }
                    int k = Input.InputChiffre() ;
                    if(k < this.getTerrain().getNombrePokemonSurTerrain() || k > this.getTerrain().getNombrePokemonSurTerrain()){
                        System.out.println("Mauvais nombre");
                    }
                    else {
                        pokemonChoisi = this.getTerrain().getPokemonSurTerrain(k);
                        pokemon.utiliserPouvoir(pokemonChoisi);

                        break;
                    }

                }

                if(j == 2){

                    System.out.println("Quel Pokemon va subir le pouvoir ?");
                    for(int h = 0 ; h < this.getTerrain().getNombrePokemonSurTerrain() ; h++){
                        System.out.println(h+1 + " : "+ adversaire.getTerrain().getPokemonSurTerrain(j).toString());
                    }
                    int k = Input.InputChiffre() ;
                    if(k < this.getTerrain().getNombrePokemonSurTerrain() || k > adversaire.getTerrain().getNombrePokemonSurTerrain()){
                        System.out.println("Mauvais nombre");
                    }
                    else {
                        pokemonChoisi = this.getTerrain().getPokemonSurTerrain(k);
                        pokemon.utiliserPouvoir(pokemonChoisi);

                        break;
                    }
                }
                else{
                    System.out.println("Erreur");
                }
            }
            if(i == 2){
                break ;
            }
            if(i == 3){
                System.out.println(pokemon.getPouvoir().getDescription());
            }

        }

    }


     */

    public void inputUtiliserPouvoir(Pokemon pokemon , Adversaire adversaire){
        while(true){
            System.out.println("Voulez vous utiliser le pouvoir " + pokemon.getPouvoir().getNom() + " ? (1 : Oui | 2 : Non | 3 : Description du pouvoir.") ;
            int i = Input.InputChiffre();
            if(i == 1){
                inputUtiliserPouvoir2(pokemon , adversaire);
                break ;
            }
            if(i == 2){
                break ;
            }
            if(i == 3){
                System.out.println(pokemon.getPouvoir().getDescription());
            }
            else{
                System.out.println("Mauvaise valeur 1");
            }
        }
    }

    public void inputUtiliserPouvoir2(Pokemon pokemon , Adversaire adversaire){
        if(pokemon.getPouvoir().getCible() == 0){
            inputJouerPouvoir(pokemon, this);
        }
        else{
            inputJouerPouvoir(pokemon, adversaire);
        }
    }

    public void inputJouerPouvoir(Pokemon pokemon , Joueur joueur){
        String chaine = "" ;
        while(true) {
            for (int a = 0; a < joueur.getTerrain().getNombrePokemonSurTerrain(); a++) {

                chaine += " " + (a + 1) + " ";
            }

            for (int h = 0; h < joueur.getTerrain().getNombrePokemonSurTerrain(); h++) {
                System.out.println(h + 1 + " : " + joueur.getTerrain().getPokemonSurTerrain(h).toString());
            }
            System.out.println("Quel Pokemon va subir le pouvoir ?");
            int k = Input.InputChiffre();
            if (k < 1 || k > joueur.getTerrain().getNombrePokemonSurTerrain()) {
                System.out.println("Mauvais nombre");
            }
            else {
                Pokemon pokemonChoisi;
                pokemonChoisi = joueur.getTerrain().getPokemonSurTerrain(k -1);
                pokemon.utiliserPouvoir(pokemonChoisi);
                break ;


            }
        }
    }



}
