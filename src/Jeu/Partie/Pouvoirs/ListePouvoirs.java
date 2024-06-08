package Jeu.Partie.Pouvoirs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Jeu.Partie.Pouvoirs.* ;

public class ListePouvoirs {
    private ArrayList<Pouvoir> m_listePouvoir = new ArrayList<>() ;
    private ArrayList<Pouvoir> m_listePouvoirPart1 = new ArrayList<>() ;
    private ArrayList<Pouvoir> m_listePouvoirPart2 = new ArrayList<>() ;

    public ListePouvoirs() {

        AffiniteEther ether = new AffiniteEther();
        AffinitePlomb plomb = new AffinitePlomb();
        Berserk berserk = new Berserk();
        Fear fear = new Fear();
      //  FerveurGuerriere ferveurGuerriere = new FerveurGuerriere();
      //  Kamikaze kamikaze = new Kamikaze();
     //   Poison poison = new Poison();
        Regeneration regeneration = new Regeneration();
        Resistance resistance = new Resistance();
        SimpleHeal simpleHeal = new SimpleHeal();
        TotalHeal totalHeal = new TotalHeal();
        m_listePouvoir.add(ether);
        m_listePouvoir.add(plomb);
        m_listePouvoir.add(berserk);
        m_listePouvoir.add(fear);
    //    m_listePouvoir.add(ferveurGuerriere);
    //    m_listePouvoir.add(kamikaze);
     //   m_listePouvoir.add(poison);
        m_listePouvoir.add(regeneration);
        m_listePouvoir.add(resistance);
        m_listePouvoir.add(simpleHeal);
        m_listePouvoir.add(totalHeal);


        for(int i = 0 ; i <= m_listePouvoir.size() / 2; i++){
            Random r = new Random() ;
            int random = r.nextInt(m_listePouvoir.size() / 2) ;

            m_listePouvoirPart1.add(m_listePouvoir.get(random)) ;
            m_listePouvoir.remove(random) ;

        }

        for(int i = 0 ; i < m_listePouvoir.size(); i++){
            m_listePouvoirPart2.add(m_listePouvoir.get(i)) ;
            m_listePouvoir.remove(i) ;

        }



    }

    public int getNombrePouvoirs(){
        return m_listePouvoir.size() ;
    }

    public Pouvoir getPouvoir(int index){
        return m_listePouvoir.get(index) ;
    }

    public ArrayList getListePouvoirPart1(){
        return m_listePouvoirPart1 ;
    }

    public ArrayList getListePouvoirPart2(){
        return m_listePouvoirPart2 ;
    }
}
