# Groupe Reutenauer

## Début de la semaine

Analyse du README et du UML
Seul dans le binome pour le moment car tous les autres étudiants étaient déja dans un binome.

### Diagramme UML

#### Modification avec la Semaine 1

La classe enumeration nomPokemon a été supprimé pour en faire une vrai classe en tant qu'ArrayList pour une utilisation plus facile

#### Ajout de classes

- GameOver
- Victoire
- NomPokemon
- Musique
- JeuPokemon

Ces classes ont été rajoutées afin d'ameliorer le programme et l'experience Utilisateur.
### Code

#### Pokemon

- Ajout de la méthode "Attaque" qui permet d'attaquer un Pokemon. 
- Rajout de l'aléatoire (a partir de la méthode "choixNom") lors du choix du Nom du Pokemon.
- Modification du nom de la méthode ChoixType en choixType pour respecter les noms de méthodes a avoir.
- Rajout des différentes methodes de get... afin de pouvoir utiliser les attributs privées en dehors de la classe.

#### Pioche 

Modification de la classe "Pioche"
- Ajout d'un attribut privée "m_nombrePokemonDansLaPioche" afin de pouvoir l'utiliser lors de l'ajout d'une carte dans la Main (une carte est pris au hasard dans la Pioche) 

Ajout des différentes méthodes : 
- Le constructeur appele la méthode "genererPioche" qui ajoute 21 Pokémons dans la Pioche. 
- Puis il initialise la taille de la pioche.
- Ajout d'une méthode "afficherPioche" qui a surtout servi de test pour verifier que la Pioche fonctionner bien (a voir si elle doit être retirer ou pas.) 
- Ajout des différentes méthodes get... afin d'utiliser les attributs privées en dehors de la classe.
- Ajout de la méthode "removePokemonDansLaPioche" afin de pouvoir retirer un Pokemon de la pioche lorsque le Joueur a piocher.


#### Tour

Création de la classe "Tour".
Classe Tour fonctionelle.

#### Terrain

- Creation de la classe "Terrain". Chaque Joueur a son terrain.
- Il y a aussi une méthode pour afficher le Terrain. l'affichage est différent de celui du readme.md car plus facile a implémenté. il reste tous de fois lisible.
- Une autre méthode pour verifier si un des Pokemons posé sur le terrain n'a plus de PV afin de l'ajouter a la defausse. 
- Et une méthode pour optenir un des Pokemons a un Int sur le Terrain.

#### Main

- Creation de la classe "Main" a ne pas confondre avec le main du programme "JeuPP"
- Elle possède en attribut privé une ArrayList avec les Pokemons que je Joueur a dans la main.
- Une méthode pour ajouter un Pokemon dans la Main.

#### Defausse

- Creation de la classe "Defausse" 
- ArrayList "m_pokemonDansLaDefausse" en attribut privée. Les différents Pokemons dont les PV sont tombés a zero.
- Méthode "ajoutPokemonDefausse" afin d'ajouter un Pokemon dans l'ArrayList.
- Méthode "afficheDefausse" pour afficher le contenu de la defausse. crée a des fins de débug.


#### Joueur

- Création de la classe mère "Joueur" qui a comme enfants "Utilisateur" et "Adversaire"

 Attributs privées :
- "m_piochePrivee" : La pioche de 21 cartes (pour le moment)
- "m_mainPrivee" : La main du joueur.
- "m_terrainPrivee" : Le terrain relié au Joueur.

Methodes : 
- "ajoutMain" afin de rajouter une carte depuis la Pioche dans la Main.
- "getMainPrivee" qui permet de recuper l'attribut privée (pour pouvoir ajouter des cartes sur le Terrain dans "JeuPP")

#### Utilisateur

- Creation de la classe "Utilisateur" fille de "Joueur".
- Input utilisateur semi-fonctionelle (voir onglets choses non implémentés)

#### Adversaire

- Creation de la classe "Adversaire" fille de "Joueur".
- IA de l'adversaire fonctionnelle (Il prendra le premier pokemon qu'il trouve qui sera inferieur a son Affinite ou a sa vie)
    
### Liaison entre le code le diagramme UML

- Normalement les deux sont entierement liés.

# Choses non implémentés

- Premier jour qui a uniquement 20 Pokemons dans la pioche (actuellement les deux en ont 21)
- Lorsque l'utilisateur attaque , il est obligé d'attaquer dans l'ordre 1, 2 , 3 sous risque de ne pas pouvoir attaquer avec les 3