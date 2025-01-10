package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Affinite;
import Jeu.Element.Eau;
import Jeu.Element.Feu;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class AffinitePlombTest{

    AffinitePlomb Affplomb = new AffinitePlomb() ;


    Feu feu = new Feu() ;
    Eau eau = new Eau() ;
    Pokemon poke1 = new Pokemon("Pikachu",  Affplomb, feu, 30 , 100) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , null, eau, 30 , 100) ;
    @Test
    public void test_UtilPouvoir(){
        assertNotEquals(poke2.getType().getNom() , "Plomb");
        poke1.utiliserPouvoir(poke2);
        assertEquals(poke2.getType().getNom() , "Plomb");
    }

    @Test
    public void test_AttaquePlomb(){
        poke1.attaque(poke2);
        assertNotEquals(poke1.getType().getAvantage() , poke2.getType().getFaiblesse());
    //    assertEquals(poke1.getType().getAvantage() , poke2.getType().getFaiblesse());
        poke1.utiliserPouvoir(poke2);
        poke1.attaque(poke2);
        assertEquals("*", poke2.getType().getFaiblesse()); // "*" Signifie qu'il a une faiblesse face a tous les types
    }

}