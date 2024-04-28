package Jeu;


import java.util.Random ;
import Jeu.Element.*;

public class Pokemon {

    private Affinite m_type;
    private String m_nom;
    private int m_pointDeVie;
    private int m_attaque;



    Random r = new Random();
    int randomType =  r.nextInt(1, 5);


    public Pokemon(){
        ChoixType(randomType);


        m_nom = "Dracaufeu" ;
        m_pointDeVie = ( r.nextInt(10,21)) * 10 ;
        m_attaque = ( r.nextInt(1,5)) * 10 ;
    }


    void ChoixType(int randomNumber)
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



    public String toString() {
        return  m_nom + ", " + m_type.getNom() +  " , Vie: " + m_pointDeVie + " , Attaque : " + m_attaque;
    }

}