package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Eau;
import Jeu.Element.Feu;
import Jeu.Partie.Tour;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class BerserkTest {


    Berserk berserk = new Berserk() ;
    Feu feu = new Feu() ;
    Eau eau = new Eau() ;
    Pokemon poke1 = new Pokemon("Pikachu",  berserk, feu, 30 , 100) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , null, eau, 30 , 100) ;

    @Test
    public void test_UtilPouvoir(){
        System.out.println(poke1.toString()) ;
        assertNotEquals(60 , poke1.getAttaque());
        poke1.utiliserPouvoir(poke1);
        System.out.println(poke1.toString()) ;
        assertEquals(60 , poke1.getAttaque());
    }


}