# Groupe Reutenauer

## Début du projet

Analyse du README et création du Fork Git. \
Seul dans le binome pour le moment car tous les autres étudiants étaient déja dans un binome.

### Diagramme UML

#### Les differents Packages
- Creations des différentes classes nécessaires au fonctionnement du jeu 
- L'ensemble des classes sont dans un package "Jeu" 
- Un package "Partie" avec le package Joueurs dedans ainsi que tous les classes néccesaires au déroulement de la partie
- Les joueurs sont dans un package. 

#### Liaison entre les classes

- La classe "Pokemon" utilise la classe "Affinite" 
ainsi que la classe enumeration "NomPokemon" pour choisir le nom et le type du Pokemon
- La pioche utilise ensuite cette classe pour avoir une liste de Pokemon pour la partie.
- Le joueur récupere 5 pokemon dans sa main et en pose 3 sur le terrain.
- La main permet de poser une carte sur le Terrain
- La defausse est lié au Terrain pour récupéré les Pokemon tombée au combat. 


#### Attributs privés 

- Chaque joueur a sa propre Main et sa propre Pioche ainsi que sa propre Defausse(pour éviter que 2 pokémons et le même nom dans la défausse).
- L'adversaire a son propre ordre d'attaque.


### Code

#### Pokemon

- Creation d'un pokemon avec son type , PV, attaque (le nom n'est pas encore prêt)
- Affichage sous forme d'une carte(celle coté Utilisateur) ou en ligne.

#### Elements

- Les différentes classes filles sont correctement implémenté.

#### Liaison entre le code le diagramme UML

- Les différentes classes ont tous le même nom que dans le diagramme UML.
- Elles n'ont pas encore été complétés a 100% (exemple pas de méthode "attaque" dans Pokemon)






