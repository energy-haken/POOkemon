package Jeu.Element;

public abstract class Affinite  {

    protected String m_nom ;
    protected String m_avantage ;
    protected String m_faiblesse ;

    public Affinite(String nom)
    {
        m_nom = nom;
    }
    public String getAvantage() {
        return m_avantage;
    }

    public String getFaiblesse() {
        return m_faiblesse;
    }

    public String getNom() {
        return m_nom;
    }
}
