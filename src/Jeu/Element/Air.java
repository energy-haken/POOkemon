package Jeu.Element;

public class Air extends Affinite {

    public Air(){
        super("Air");
        m_avantage = "Terre" ;
        m_faiblesse = "Feu" ;
    }

    @Override
    public String  getAvantage() {
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
