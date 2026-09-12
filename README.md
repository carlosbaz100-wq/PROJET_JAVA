# PROJET_JAVA
## Reponses au questions
### A1. Reformulons en deux phrases ce que le programme doit permettre de faire.
La solution informatique proposée permet de gérer les documents et les adhérents d'une bibliothèque en enregistrant leurs informations et en contrôlant leur disponibilité. Il assure les opérations de prêt en permettant à un adhérent d'emprunter un document disponible et de le retourner.

### A2. Relevez les objets possibles. Lesquels méritent de devenir des classes maintenant ? Justifiez.

Document est une classe abstraite car elle possède des données propres (numéro, titre, auteur, disponibilité)
et des comportements (emprunter, retourner). Elle ne s'instancie pas directement — on emprunte toujours
un Livre ou un Périodique.

Livre est une classe car elle hérite de Document avec un attribut propre (nbPages)
et une règle de prêt spécifique (21 jours).

Périodique est une classe car elle hérite de Document avec un attribut propre (numeroParution)
et une règle de prêt spécifique (7 jours).

Lecteur est une classe car elle possède des données propres (nom, prénom, numéro, adresse)
et interagit avec les documents via l'emprunt.

Emprunt n'est pas une classe car aucune date ni historique n'est modélisé —
le lien est géré par l'attribut emprunteur dans Document.

Bibliothèque n'est pas une classe car le rôle de catalogue est joué par Main.

---

### A3. Pour chaque classe retenue, proposez les attributs et leurs types.

Lecteur :
```java
private String nom
private String prenom
private int    numero
private String adresse
```

Document :
```java
private int     numero
private String  titre
private String  auteurPrincipal
private boolean disponible
private Lecteur emprunteur
```

Livre :
```java
private int nbPages
```

Périodique :
```java
private int numeroParution
```

### A4. Indiquez ce qui doit être privé et expliquez pourquoi.

Tous les attributs des classes Lecteur, Document, Livre et Periodique doivent être déclarés private.
Cela respecte le principe d'encapsulation : les données sont protégées contre toute modification directe
et incontrôlée depuis d'autres classes. L'accès se fait uniquement via des méthodes publiques (getters/setters),
ce qui permet de contrôler et valider les actions effectuées sur les objets.


### A5. Proposez un ou plusieurs constructeurs et les méthodes utiles.

Document :
```
+ Document(numero, titre, auteurPrincipal)
+ getNumero()            : int
+ getTitre()             : String
+ getAuteurPrincipal()   : String
+ getDisponible()        : boolean
+ getEmprunteur()        : Lecteur
+ emprunter(l : Lecteur) : void
+ retourner()            : void
+ dureeMaxPret()         : int
+ toString()             : String
```

Livre :
```
+ Livre(numero, titre, auteurPrincipal, nbPages)
+ dureeMaxPret() : int
+ toString()     : String
```

Périodique :
```
+ Periodique(numero, titre, auteurPrincipal, numeroParution)
+ dureeMaxPret() : int
+ toString()     : String
```

Lecteur :
```
+ Lecteur(nom, prenom, numero, adresse)
+ getNom()    : String
+ getPrenom() : String
+ toString()  : String
```


Lecteur

+Lecteur(numero, nom, prenom, email)

+afficher() : void
