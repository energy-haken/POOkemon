package Jeu.Partie.Pouvoirs;

import Jeu.Partie.Terrain;

public class ExtensionTerritoire extends Pouvoir{
    public ExtensionTerritoire(){
        m_nom = "Extension du Territoire";
        m_dejaDistribuer = false ;
        m_dejaUtiliser = false ;
        m_description = "Extension du territoire : à utilisation unique :  le terrain du joueur gagne un quatrième emplacement sur lequel il peut placer immédiatement un Pokémon de sa main. " +
                "Lorsque le Pokémon qui a utilisé ce pouvoir meurt, son emplacement est perdu et le terrain possède de nouveau trois emplacements." ;
    }

    @Override
    public void utiliserLePouvoir(Terrain terrain){

    }

    // ABANDONNER POUR LE MOMENT (AUCUN MOYEN D'AVOIR PLUSIEURS PARAMETRES DIFFERENTS POUR UTILISER POUVOIR)
}
