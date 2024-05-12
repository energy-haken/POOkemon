package Jeu;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random ;
import Jeu.Element.*;

public class Pokemon {

    private Affinite m_type;
    private String m_nom;
    private int m_pointDeVie;
    private int m_attaque;
    private List<String> m_listeNomPokemon = new ArrayList<>(Arrays.asList("Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran", "Nidorina", "Nidoqueen", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide", "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur", "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge", "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra", "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor", "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch", "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton", "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv", "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik", "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Electrode", "Noeunoeuf", "Noadkoko", "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne", "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène", "Poissoroy", "Stari", "Staross", "M. Mime", "Insécateur", "Lippoutou", "Elektek", "Magmar", "Scarabrute", "Tauros", "Magicarpe", "Léviator", "Lokhlass", "Métamorph", "Evoli", "Aquali", "Voltali", "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex", "Artikodin", "Electhor", "Sulfura", "Minidraco", "Draco", "Dracoloss", "Mewtwo", "Mew"));

    // Initialisations des différents aleatoires
    Random r = new Random();
    int randomType =  r.nextInt(1, 5);
    int randomNom = r.nextInt(m_listeNomPokemon.size());


    /**
     * Constructueur : Tout les valeur sont aléatoire
     */

    public Pokemon(){
        choixType(randomType);
        choixNom(randomNom);

        m_pointDeVie = ( r.nextInt(10,21)) * 10 ;
        m_attaque = ( r.nextInt(1,5)) * 10 ;
    }

    /**
     * Methode pour configurer m_type aléatoire au Pokemon
     * Utilisation d'un switch
     * @param randomNumber
     */

    void choixType(int randomNumber)
    {
        switch(randomNumber){
            case 1 :
                m_type = new Eau() ;
                break ;
            case 2 :
                m_type = new Feu() ;
                break ;
            case 3 :
                m_type = new Air() ;
                break ;
            case 4 :
                m_type = new Terre() ;
                break ;
        }

    }

    /**
     * Methode pour donner m_nom aléatoire au Pokemon parmi la liste m_listeNomPokemon
     * @param randomNumber
     */
    void choixNom(int randomNumber){
        m_nom = m_listeNomPokemon.get(randomNumber);
        m_listeNomPokemon.remove(randomNumber);
    }


    /**
     * Renvoie l'affichage des données du Pokemon sous la forme d'une carte.
     * @return une carte Pokemon
     */
    public String getCartePoke(){

        String ligneHaut = "*--------------------*" ;
        String ligneNom = "|     " + m_nom ;
        String ligneAffinite = "| Affinite : " + m_type.getNom() ;
        String ligneVie = "| Vie : " + m_pointDeVie ;
        String ligneAttaque = "| Attaque : " + m_attaque;
        String ligneBas = "*--------------------*";

        int tailleLigneHaut = ligneHaut.length();
        int tailleLigneNom = ligneNom.length();
        int tailleLigneAffinite = ligneAffinite.length();
        int tailleLigneVie = ligneVie.length();
        int tailleLigneAttaque = ligneAttaque.length();

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneNom - 1; i++){
            ligneNom += " " ;
        }
        ligneNom += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneAffinite - 1; i++){
            ligneAffinite += " " ;
        }
        ligneAffinite += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneVie - 1; i++){
            ligneVie += " " ;
        }
        ligneVie += "|" ;

        for(int i = 0 ; i < tailleLigneHaut - tailleLigneAttaque - 1; i++){
            ligneAttaque += " " ;
        }
        ligneAttaque += "|" ;


        return ligneHaut + "\n" + ligneNom + "\n" + ligneAffinite + "\n" + ligneVie + "\n" + ligneAttaque + "\n" + ligneBas;
    }

    /**
     * Attaquez un autre pokemon
     * @param pokemon
     */

    public void attaque(Pokemon pokemon){
        pokemon.m_pointDeVie -= this.m_attaque ;
    }

    /**
     *
     * @return Un String comportant les différentes valeurs du pokemon sur une ligne
     */

    public String toString() {
        return  m_nom + ", " + m_type.getNom() +  " , Vie: " + m_pointDeVie + " , Attaque : " + m_attaque;
    }

    /**
     *
     * @return le nom du Pokemon en tant que String
     */
    public String getNom(){
        return m_nom;
    }

    /**
     *
     * @return Le type du Pokemon
     */
    public String getType(){
        return m_type.getNom() ;
    }

    /**
     *
     * @return Le nombre de Points de Vie du Pokemon au format int
     */
    public int getPointDeVie(){
        return m_pointDeVie;
    }

    /**
     *
     * @return la valeur d'attaque du Pokemon au format int
     */
    public int getAttaque(){
        return m_attaque;
    }

}