package Jeu.Partie.Pouvoirs;

import static org.junit.jupiter.api.Assertions.*;

import Jeu.Element.Feu;
import Jeu.Pokemon;
import org.junit . jupiter .api.Test;

class RegenerationTest {


    Regeneration regeneration = new Regeneration();
    Fear fear = new Fear();
    Feu feu = new Feu();
    Pokemon poke1 = new Pokemon("Pikachu" , regeneration , feu , 30, 100 ) ;
    Pokemon poke2 = new Pokemon("Dracofeu" , fear, feu, 30 , 100) ;
    Pokemon poke3 = new Pokemon("Mew" , null, feu, 30 , 100) ;
    Pokemon poke4 = new Pokemon("Carapuce" , null, feu, 30 , 100) ;


    @Test
    public void test_utilPouvoir(){
        poke2.utiliserPouvoir(poke3);
        assertEquals(poke2.getPouvoir().getDejaUtiliser() , true);
        poke1.utiliserPouvoir(poke2);
        assertEquals(poke2.getPouvoir().getDejaUtiliser() , false);
        poke2.utiliserPouvoir(poke4);
        assertEquals(poke2.getPouvoir().getDejaUtiliser() , true);
        System.out.println(poke2.getPouvoir().getNom()) ;
    }
}