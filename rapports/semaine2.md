# Groupe Reutenauer

## Début de la semaine

Analyse du README et du UML
Seul dans le binome pour le moment car tous les autres étudiants étaient déja dans un binome.

### Diagramme UML

#### Modification avec la Semaine 1

- la classe Enumeration nomPokemon a été supprimé et est devenu un attribut ArrayList de la classe Pokemon pour une mise en place plus facile.


#### Attributs privés

- La classe Pokemon a optenu un attribut privé en plus "m_listeNomPokemon"


### Code

#### Pokemon

- Ajout de la méthode "Attaque" qui permet d'attaquer un Pokemon. (pour le moment tous les Pokemons fonctionnent qu'il soit adversaire ou equipier, + pas de changement par rapport au Type du Pokemon)
- Rajout de l'aléatoire (a partir de la méthode "choixNom") lors du choix du Nom du Pokemon.
- Modification du nom de la méthode ChoixType en choixType pour respecter les noms de méthodes a avoir.
- Rajout des différentes methodes de get... afin de pouvoir utiliser les attributs privées en dehors de la classe.

#### Pioche 

Modification de la classe "Pioche"
- Ajout d'un attribut privée "m_nombrePokemonDansLaPioche" afin de pouvoir l'utiliser lors de l'ajout d'une carte dans la Main (une carte est pris au hasard dans la Pioche) 

Ajout des différentes méthodes : 
- Le constructeur appele la méthode "genererPioche" qui ajoute 21 Pokémons dans la Pioche. (Pas encore de système de Tour pour faire la différence entre le premier Joueur et le deuxieme.) 
- Puis il initialise la taille de la pioche.
- Ajout d'une méthode "afficherPioche" qui a surtout servi de test pour verifier que la Pioche fonctionner bien (a voir si elle doit être retirer ou pas.) 
- Ajout des différentes méthodes get... afin d'utiliser les attributs privées en dehors de la classe.
- Ajout de la méthode "removePokemonDansLaPioche" afin de pouvoir retirer un Pokemon de la pioche lorsque le Joueur a piocher.


#### Tour

Création de la classe "Tour" afin de l'utiliser plus tard, elle est actuellement vide.

#### Terrain

- Creation de la classe "Terrain" , Il y a un seul Terrain pour les 2 joueurs, tous les Pokemons posé sur le terrain sont dans une ArrayList.
- L'adversaire ajoute depuis le debut de la liste et l'utilisateur depuis la fin.
- Il y a aussi une méthode pour afficher le Terrain. l'affichage est différent de celui du readme.md car plus facile a implémenté. il reste tous de fois lisible.
- Une autre méthode pour verifier si un des Pokemons posé sur le terrain n'a plus de PV afin de l'ajouter a la defausse. (pour le moment il est simplement supprimé du terrain).
- Et une méthode pour optenir un des Pokemons a un Int sur le Terrain.

#### Main

- Creation de la classe "Main" a ne pas confondre avec le main du programme "JeuPP"
- Elle possède en attribut privé une ArrayList avec les Pokemons que je Joueur a dans la main.
- Une méthode pour ajouter un Pokemon dans la Main.
- Deux méthode pour ajouter un Pokemon sur le Terrain, différente en fonction du Joueur (a voir si un Override pourrait fonctionner)
- Pas encore de taille limite aux nombres de Pokemons dans la Main.

#### Defausse

- Creation de la classe "Defausse" 
- ArrayList "m_pokemonDansLaDefausse" en attribut privée. Les différents Pokemons dont les PV sont tombés a zero.
- Méthode "ajoutPokemonDefausse" afin d'ajouter un Pokemon dans l'ArrayList.
- Méthode "afficheDefausse" pour afficher le contenu de la defausse.
- Cette classe n'est pas encore utilisée car elle n'est pas encore reliée avec le reste.

#### Joueur

- Création de la classe mère "Joueur" qui a comme enfants "Utilisateur" et "Adversaire"

 Attributs privées :
- "m_piochePrivee" : La pioche de 21 cartes (pour le moment)
- "m_mainPrivee" : La main du joueur.
- "m_defaussePrivee" qui va peut etre être supprimé en fonction de comment la Defausse va être relié.

Methodes : 
- "ajoutMain" qui permet de rajouter une carte depuis la Pioche dans la Main.
- "getMainPrivee" qui permet de recuper l'attribut privée (pour pouvoir ajouter des cartes sur le Terrain dans "JeuPP")

#### Utilisateur

- Creation de la classe "Utilisateur" fille de "Joueur" classe vide pour le moment.

#### Adversaire

- Creation de la classe "Adversaire" fille de "Joueur" classe vide pour le moment.
    
### Liaison entre le code le diagramme UML

- Les différentes classes ont tous le même nom que dans le diagramme UML.
- Elles n'ont pas encore été complétés a 100% 
