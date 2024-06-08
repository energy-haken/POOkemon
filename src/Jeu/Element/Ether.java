package Jeu.Element;

public class Ether extends Affinite {
    public Ether() {
        super("Ether");
    }

    @Override
    public String getFaiblesse(){
        return "." ;
    }

    @Override
    public String getAvantage(){
        return "*" ;
    }
}
