package Jeu;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random ;
import Jeu.Element.*;
import Jeu.Partie.NomPokemon;
import Jeu.Partie.Pouvoirs.ListePouvoirs;
import Jeu.Partie.Pouvoirs.Pouvoir;

public class Pokemon {

    private Affinite m_type;
    private String m_nom;
    private int m_pointDeVie;
    private int m_attaque;
    private int m_MaxVie ;
    private NomPokemon m_nomPokeQuiReste;
    private int m_resitance = 0 ;
    private int m_peur = 0 ;
    private Pouvoir m_pouvoir ;

    // Initialisations des différents aleatoires
    Random r = new Random();
    int randomType =  r.nextInt(1, 5);



    /**
     * Constructueur : Tout les valeur sont aléatoire
     */

    public Pokemon(NomPokemon nomPokemon , ListePouvoirs pouvoir){
        m_nomPokeQuiReste = nomPokemon;
        choixType(randomType);

        int randomNom = r.nextInt(m_nomPokeQuiReste.getNombrePokemons());
        choixNom(randomNom);

        int randomPouvoir = r.nextInt(pouvoir.getNombrePouvoirs());
        choixPouvoir(randomPouvoir , pouvoir);

        m_pointDeVie = ( r.nextInt(10,21)) * 10 ;
        m_MaxVie = m_pointDeVie ;
        m_attaque = ( r.nextInt(1,5)) * 10 ;
    }

    /**
     * Methode pour configurer m_type aléatoire au Pokemon
     * Utilisation d'un switch
     * @param randomNumber
     */

    void choixType(int randomNumber)
    {
        switch(randomNumber){
            case 1 :
                m_type = new Eau() ;
                break ;
            case 2 :
                m_type = new Feu() ;
                break ;
            case 3 :
                m_type = new Air() ;
                break ;
            case 4 :
                m_type = new Terre() ;
                break ;
        }

    }

    /**
     * Methode pour donner m_nom aléatoire au Pokemon parmi la liste m_listeNomPokemon
     * @param randomNumber
     */
    void choixNom(int randomNumber){
        m_nom = m_nomPokeQuiReste.choixNomPokemon(randomNumber);

    }

    void choixPouvoir(int randomNumber , ListePouvoirs pouvoirsQuiReste){
        Random r = new Random();
        int random = r.nextInt(2) ;
        for(int i = 0 ; i <= randomNumber ; i++){
            if(random == 1 && pouvoirsQuiReste.getPouvoir(i).getDejaDistribuer() == false){
                m_pouvoir = pouvoirsQuiReste.getPouvoir(i);
                pouvoirsQuiReste.getPouvoir(i).distribuer();


            }

            else{
                m_pouvoir = null ;
            }
        }
    }


    /**
     * Renvoie l'affichage des données du Pokemon sous la forme d'une carte.
     * @return une carte Pokemon
     */
    public String getCartePoke(){

        String ligneHaut = "*--------------------*" ;
        String ligneNom = "|     " + m_nom ;
        String ligneAffinite = "| Affinite : " + m_type.getNom() ;
        String ligneVie = "| Vie : " + m_pointDeVie ;
        String ligneAttaque = "| Attaque : " + m_attaque;
        String ligneBas = "*--------------------*";

        int tailleLigneHaut = ligneHaut.length();
        int tailleLigneNom = ligneNom.length();
        int tailleLigneAffinite = ligneAffinite.length();
        int tailleLigneVie = ligneVie.length();
        int tailleLigneAttaque = ligneAttaque.length();

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneNom - 1; i++){
            ligneNom += " " ;
        }
        ligneNom += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneAffinite - 1; i++){
            ligneAffinite += " " ;
        }
        ligneAffinite += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneVie - 1; i++){
            ligneVie += " " ;
        }
        ligneVie += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneAttaque - 1; i++){
            ligneAttaque += " " ;
        }
        ligneAttaque += "|" ;


        return ligneHaut + "\n" + ligneNom + "\n" + ligneAffinite + "\n" + ligneVie + "\n" + ligneAttaque + "\n" + ligneBas;
    }

    /**
     * Attaquez un autre pokemon
     * @param pokemon
     */

    public void attaque(Pokemon pokemon){

        Musique.playMusic("src/Jeu/Sons/AttackSound.wav");
        int attaque = this.m_attaque - pokemon.m_resitance;
        String typeAdvers = pokemon.getType().getNom() ;
        System.out.println(this.m_nom + " attaque " +  pokemon.getNom() + " !");
        if(pokemon.m_resitance != 0){
            System.out.println(pokemon.getNom() + " résiste !");
        }
        if(this.m_type.getAvantage() == typeAdvers || typeAdvers == "Plomb" || this.m_type.getAvantage() == "*"){
            System.out.println("Attaque Super Efficace !");
          //  Musique.playMusic("src/Jeu/Critical Damage.WAV");
            attaque += 10 ;

            pokemon.m_pointDeVie -= attaque ;
            System.out.println(attaque + " points de dégats !");


        }
        else if(this.m_type.getFaiblesse() == typeAdvers || typeAdvers == "Ether"){
            System.out.println("mais " + pokemon.getNom() + " n'a pas peur de l'attaque !");
            attaque -= 10 ;
    //        Musique.playMusic("src/Jeu/youSuck.WAV");
            pokemon.m_pointDeVie -= attaque ;
            System.out.println(attaque + " points de dégats !");

        }
        else {
            pokemon.m_pointDeVie -= attaque;
            System.out.println(attaque + " points de dégats !");

        }
        System.out.println() ;
        if(pokemon.m_pointDeVie < 0 ){
            pokemon.m_pointDeVie = 0;
        }
    }

    /**
     *
     * @return Un String comportant les différentes valeurs du pokemon sur une ligne
     */

    public String toString() {
        if(m_pouvoir == null) {

            return m_nom + ", " + m_type.getNom() + " , Vie: " + m_pointDeVie + " , Attaque : " + m_attaque;
        }
        else{
            return  m_nom + ", " + m_pouvoir.getNom() + ", " + m_type.getNom() + " , Vie: " + m_pointDeVie + " , Attaque : " + m_attaque;
        }
    }

    /**
     *
     * @return le nom du Pokemon en tant que String
     */
    public String getNom(){
        return m_nom;
    }

    /**
     *
     * @return Le type du Pokemon
     */
    public Affinite getType(){
        return m_type;
    }

    /**
     *
     * @return Le nombre de Points de Vie du Pokemon au format int
     */
    public int getPointDeVie(){
        return m_pointDeVie;
    }

    /**
     *
     * @return la valeur d'attaque du Pokemon au format int
     */
    public int getAttaque(){
        return m_attaque;
    }

    public void Tuer(Pokemon pokemon){
        pokemon.m_pointDeVie = 0 ;
    }

    public Pouvoir getPouvoir(){
        return m_pouvoir ;
    }

    public void utiliserPouvoir(Pokemon pokemon){
        if(m_pouvoir != null){
            m_pouvoir.utiliserLePouvoir(pokemon);
        }

        else{

        }

    }

    public void changerType(Affinite affinite){
        m_type = affinite ;
    }

    public void changerAttaque(int valeur){
        m_attaque = valeur ;
    }

    public void changerVie(int valeur){
        m_pointDeVie = valeur ;

        if (m_pointDeVie > m_MaxVie){
            m_pointDeVie = m_MaxVie ;
        }
    }

    public void tuer(Pokemon pokemon){
        pokemon.m_pointDeVie = 0 ;
    }

    public int getMaxVie(){
        return m_MaxVie ;
    }

    public void changerResitance(int i){
        m_resitance = i ;
    }

}