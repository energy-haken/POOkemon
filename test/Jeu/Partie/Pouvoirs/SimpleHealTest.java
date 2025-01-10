package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Feu;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class SimpleHealTest {
    SimpleHeal heal = new SimpleHeal();
    Feu feu = new Feu();
    Pokemon poke1 = new Pokemon("Pikachu" , heal , feu , 30, 100 ) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , null, feu, 30 , 100) ;



    @Test
    public void test_utilPouvoir() {
        poke2.attaque(poke1);
        assertEquals(poke1.getPointDeVie() , 70 );
        System.out.println(poke1.getPointDeVie());
        poke1.utiliserPouvoir(poke1);
        System.out.println(poke1.getPointDeVie());
        assertEquals(poke1.getPointDeVie() , 100 );
    }

}