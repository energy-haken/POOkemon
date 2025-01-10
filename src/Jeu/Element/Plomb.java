package Jeu.Element;



public class Plomb extends Affinite {
    public Plomb() {
        super("Plomb");
    }

    @Override
    public String getFaiblesse(){
        return "*" ;
    }

    @Override
    public String getAvantage(){
        return "." ;
    }
}
