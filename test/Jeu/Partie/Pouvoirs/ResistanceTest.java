package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Feu;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class ResistanceTest {


    Resistance resistance = new Resistance();
    Feu feu = new Feu();
    Pokemon poke1 = new Pokemon("Pikachu" , resistance , feu , 30, 100 ) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , null, feu, 30 , 100) ;



    @Test
    public void test_utilPouvoir() {
        poke2.attaque(poke1);
        assertNotEquals(poke1.getPointDeVie() , 80 );
        poke1.utiliserPouvoir(poke1);
        poke1.changerVie(100);
        poke2.attaque(poke1);
        assertEquals(poke1.getPointDeVie() , 80 );
    }
}