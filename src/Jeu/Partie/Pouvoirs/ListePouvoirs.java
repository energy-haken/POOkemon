package Jeu.Partie.Pouvoirs;

import java.util.ArrayList;
import java.util.List;

import Jeu.Partie.Pouvoirs.* ;

public class ListePouvoirs {
    private ArrayList<Pouvoir> m_listePouvoir = new ArrayList<>() ;

    public ListePouvoirs() {

        AffiniteEther ether = new AffiniteEther();
        AffinitePlomb plomb = new AffinitePlomb();
        Berserk berserk = new Berserk();

      //  Fear fear = new Fear();
      //  FerveurGuerriere ferveurGuerriere = new FerveurGuerriere();
      //  Kamikaze kamikaze = new Kamikaze();
     //   Poison poison = new Poison();
     //   Regeneration regeneration = new Regeneration();
     //   Resistance resistance = new Resistance();
        SimpleHeal simpleHeal = new SimpleHeal();
        TotalHeal totalHeal = new TotalHeal();
        m_listePouvoir.add(ether);
        m_listePouvoir.add(plomb);


        m_listePouvoir.add(berserk);

    //    m_listePouvoir.add(fear);
    //    m_listePouvoir.add(ferveurGuerriere);
    //    m_listePouvoir.add(kamikaze);
     //   m_listePouvoir.add(poison);
    //    m_listePouvoir.add(regeneration);
    //    m_listePouvoir.add(resistance);
        m_listePouvoir.add(simpleHeal);
        m_listePouvoir.add(totalHeal);


    }

    public int getNombrePouvoirs(){
        return m_listePouvoir.size() ;
    }

    public Pouvoir getPouvoir(int index){
        return m_listePouvoir.get(index) ;
    }
}
