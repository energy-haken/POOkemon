package Jeu.Element;

public class Eau extends Affinite {


    public Eau(){
        super("Eau");
        m_avantage = "Feu" ;
        m_faiblesse = "Terre" ;
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
