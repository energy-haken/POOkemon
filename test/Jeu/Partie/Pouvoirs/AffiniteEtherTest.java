package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Eau;
import Jeu.Element.Feu;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class AffiniteEtherTest {
    AffiniteEther AffEther = new AffiniteEther() ;


    Feu feu = new Feu() ;
    Eau eau = new Eau() ;
    Pokemon poke1 = new Pokemon("Pikachu",  AffEther, feu, 30 , 100) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , null , eau, 30, 100) ;
    @Test
    public void test_UtilPouvoir(){
        assertNotEquals(poke2.getType().getNom() , "Ether");
        poke1.utiliserPouvoir(poke1);
        assertEquals(poke1.getType().getNom() , "Ether");
    }

    @Test
    public void test_AttaqueEther(){
        poke1.attaque(poke2);
        assertNotEquals(poke1.getType().getAvantage() , poke2.getType().getFaiblesse());
        //    assertEquals(poke1.getType().getAvantage() , poke2.getType().getFaiblesse());
        poke1.utiliserPouvoir(poke1);
        poke1.attaque(poke2);
        assertEquals("*", poke1.getType().getAvantage()); // "*" Signifie qu'il a une faiblesse face a tous les types
    }
}