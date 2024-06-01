package Jeu.Element;

public class Feu extends Affinite {


    public Feu(){
        super("Feu");
        m_avantage = "Air" ;
        m_faiblesse = "Eau" ;
    }

    @Override
    public String getAvantage() {
        return m_avantage;
    }

    @Override
    public String getFaiblesse() {
        return m_faiblesse;
    }

    @Override
    public String getNom() {
        return m_nom;
    }

}
