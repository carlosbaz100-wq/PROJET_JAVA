# CAHIER DES CHARGES FONCTIONNEL
## Application de Gestion de Bibliothèque en Java

**Cours** : Programmation Orientée Objet — Java (POO IIAA511)  
**Groupe** : 8  
**Membres** : DAMBA Aimée · KOUSSE Souleymane · BAZONGO Carlos  
**Encadrant** : Dr Babacar LEYE  
**Année académique** : 2026 – 2027

---

## 1. Présentation du projet

| Élément | Description |
|---|---|
| Intitulé | Application de Gestion de Bibliothèque en Java |
| Domaine | Programmation Orientée Objet — Java (POO IIAA511) |
| Commanditaire (simulé) | Un bibliothécaire souhaitant informatiser la gestion de ses documents et de ses prêts |
| Réalisateurs | Groupe 8 — DAMBA Aimée, KOUSSE Souleymane, BAZONGO Carlos |
| Encadrant | Dr Babacar LEYE — Institut 2iE, Ouagadougou |
| Langage / Environnement | Java JDK 17+ — exécution en ligne de commande |

---

## 2. Contexte

### 2.1 Le cadre

La bibliothèque de l'Institut 2iE, comme la plupart des bibliothèques universitaires et municipales, gère quotidiennement un fonds documentaire composé de deux grandes familles de documents :

- des **Livres**, qui peuvent être empruntés par les adhérents et sortis de l'établissement ;
- des **Périodiques** (revues, magazines scientifiques), qui doivent rester consultables sur place et ne peuvent en aucun cas être empruntés.

À cela s'ajoutent des **lecteurs** (étudiants, enseignants, chercheurs), identifiés par un numéro d'adhérent, et qui interagissent avec le fonds par des emprunts et des retours.

### 2.2 Le problème observé

Aujourd'hui, la gestion de ce fonds repose encore largement sur un **registre papier** ou sur des **tableurs peu structurés**. Cette méthode, bien que simple, entraîne plusieurs dysfonctionnements récurrents :

- **Doubles emprunts** : un même livre peut être prêté à deux lecteurs différents faute de vérification systématique.
- **Retours non tracés** : l'emprunteur n'est pas toujours effacé du registre, ce qui rend le livre « fantôme » — physiquement disponible mais marqué comme emprunté.
- **Confusion entre documents** : certains périodiques sont parfois empruntés alors qu'ils devraient rester en salle de lecture.
- **Recherche lente** : retrouver un document par son titre sur un registre papier prend plusieurs minutes, surtout quand le fonds grossit.
- **Aucune vue d'ensemble** : impossible de savoir en un coup d'œil quels documents sont disponibles, ni qui détient quoi.

### 2.3 Le besoin exprimé

Le bibliothécaire souhaite disposer d'un **outil informatique simple, fiable et exécutable en ligne de commande**, qui lui permette de :

- gérer son catalogue de documents de manière centralisée ;
- enregistrer les emprunts et les retours **sans risque d'incohérence** ;
- distinguer automatiquement les documents empruntables des documents consultables ;
- retrouver rapidement un document par son titre ;
- consulter à tout moment l'état du fonds (disponibles, empruntés, en consultation).

### 2.4 Pourquoi la Programmation Orientée Objet

Ce problème se prête naturellement à une modélisation orientée objet : les **documents**, les **lecteurs** et la **bibliothèque** sont des entités distinctes, avec leurs propres données et comportements. De plus, la coexistence de documents aux règles différentes (empruntables vs consultables) appelle une **hiérarchie de classes** et des **interfaces** — ce qui fait de ce projet un terrain d'application idéal pour les concepts étudiés en cours (abstraction, héritage, polymorphisme).

---

## 3. Problématique

> **Comment concevoir une application Java capable de gérer de manière fiable et cohérente les documents d'une bibliothèque, en distinguant clairement les documents empruntables des documents consultables sur place, tout en évitant les incohérences de données (double emprunt, retour invalide, consultation simultanée) ?**

Cette problématique se décline en trois sous-questions :

1. **Comment modéliser** des documents de natures différentes (Livres, Périodiques) tout en partageant un socle commun ?
2. **Comment garantir** qu'un Livre ne soit jamais emprunté par deux lecteurs en même temps, et qu'un retour ne soit jamais enregistré à tort ?
3. **Comment appliquer** les principes de la POO (abstraction, héritage, interfaces, polymorphisme) pour produire un code extensible et maintenable ?

Le problème de fond est simple : sur un registre papier, aucune de ces vérifications n'est automatique. Une application mal conçue reproduirait les mêmes incohérences.

---

## 4. Solution proposée

Nous proposons une application Java qui **modélise la bibliothèque comme un ensemble d'objets** organisés selon une hiérarchie claire, et qui **centralise les règles métier** dans les classes elles-mêmes — de sorte qu'il soit **impossible de créer une incohérence**, même en cas d'erreur de manipulation.

### 4.1 Principe directeur

> **Chaque document est responsable de son propre état. Toute tentative d'action invalide est refusée avec un message explicite, et l'état reste inchangé.**

Autrement dit : le système ne se contente pas d'enregistrer les actions du bibliothécaire ; il **les valide** avant de les appliquer.

### 4.2 Réponse à la problématique

| Sous-question | Réponse apportée par notre solution |
|---|---|
| Comment modéliser des documents de natures différentes ? | Une **classe abstraite `Document`** factorise l'état commun (`id`, `titre`, `disponible`). Deux sous-classes concrètes (`Livre`, `Periodique`) spécialisent le comportement. |
| Comment distinguer empruntable et consultable ? | Deux **interfaces** séparent les capacités : `Empruntable` (pour les Livres) et `Consultable` (pour les Périodiques). Un Périodique ne peut donc **jamais** être emprunté, et un Livre **jamais** consulté sur place. |
| Comment éviter les incohérences ? | Les méthodes `emprunter()`, `retourner()`, `consulterSurPlace()` et `terminerConsultation()` **vérifient l'état avant d'agir** et refusent toute action invalide. |
| Comment garantir un code extensible ? | L'affichage du catalogue repose sur un **appel polymorphe** à `description()`. Ajouter un nouveau type de document (DVD, Thèse…) ne nécessite **aucune modification** de `Bibliotheque`. |

### 4.3 Choix de conception majeurs

- **Abstraction** : `Document` impose à toute sous-classe de fournir sa propre `description()`.
- **Héritage** : `Livre` et `Periodique` réutilisent l'état et les accesseurs de `Document`.
- **Interfaces** : `Empruntable` et `Consultable` modélisent des **capacités** indépendantes de la hiérarchie.
- **Encapsulation** : tous les attributs sont `private`, la modification de la disponibilité passe par une méthode `protected` contrôlée.
- **Polymorphisme** : la boucle d'affichage du catalogue appelle `description()` sans aucun `instanceof`.

### 4.4 Bénéfices attendus

- **Fiabilité** : plus de double emprunt, plus de retour fantôme.
- **Clarté** : chaque responsabilité est portée par une classe précise.
- **Extensibilité** : l'ajout d'un nouveau type de document est trivial.
- **Pédagogie** : le projet illustre concrètement les quatre piliers de la POO.

---

## 5. Acteurs du système

| Acteur | Rôle | Actions dans le système |
|---|---|---|
| Bibliothécaire | Utilisateur principal | Ajouter des documents, enregistrer emprunts/retours/consultations, rechercher, afficher le catalogue |
| Lecteur | Adhérent de la bibliothèque | Emprunter un Livre, retourner un Livre (action déclenchée par le bibliothécaire) |

---

## 6. Périmètre

**Inclus :** gestion des Livres (emprunt, retour), des Périodiques (consultation sur place), des Lecteurs, et d'un catalogue avec recherche et affichages.

**Exclu :** interface graphique, base de données, gestion des amendes et des réservations.

---

## 7. Architecture de la solution — 8 fichiers Java

| Fichier Java | Type | Rôle dans la solution | Contribution |
|---|---|---|---|
| `Empruntable.java` | Interface | Capacité « peut être emprunté » (Livres uniquement) | DAMBA Aimée |
| `Consultable.java` | Interface | Capacité « peut être consulté sur place » (Périodiques uniquement) | KOUSSE Souleymane |
| `Document.java` | Classe abstraite | Socle commun : `id`, `titre`, `disponible`, `description()` abstraite | KOUSSE Souleymane |
| `Livre.java` | Classe concrète | Étend `Document`, implémente `Empruntable` | DAMBA Aimée |
| `Periodique.java` | Classe concrète | Étend `Document`, implémente `Consultable` | KOUSSE Souleymane |
| `Lecteur.java` | Classe concrète | Adhérent : nom, prénom, numéro, adresse | DAMBA Aimée |
| `Bibliotheque.java` | Classe concrète | Catalogue, ajout, recherche, affichages | BAZONGO Carlos |
| `Main.java` | Point d'entrée | Démonstration des scénarios | BAZONGO Carlos |

---

## 8. Scénarios de validation de la solution

| N° | Scénario | Ce que la solution doit garantir |
|---|---|---|
| S1 | Emprunt normal | Le Livre devient indisponible et mémorise son emprunteur. |
| S2 | Deuxième emprunt | Refusé, avec le nom de l'emprunteur actuel affiché. |
| S3 | Retour normal | Le Livre redevient disponible, l'emprunteur est effacé. |
| S4 | Retour invalide | Refusé, état inchangé. |
| S5 | Consultation d'un Périodique | Le Périodique devient indisponible pendant la consultation, puis redevient disponible. |
| S6 | Recherche insensible à la casse | Le document est trouvé même si la casse diffère. |
| S7 | Emprunts d'un lecteur | La liste des documents empruntés est correctement restituée. |
| S8 | `getEmprunteur()` sur un Périodique | Retourne `null` : un Périodique n'a jamais d'emprunteur. |

---

## 9. Contraintes techniques

- **Langage** : Java JDK 17+.
- **Paradigme** : POO (encapsulation, héritage, abstraction, polymorphisme, interfaces).
- **Exécution** : ligne de commande (`javac` / `java`).
- **Stockage** : en mémoire uniquement (tableau de documents, capacité 100).
- **Aucune dépendance externe**.

---

## 10. Méthodologie et outils utilisés

Dans un souci de **transparence** et de **rigueur académique**, nous tenons à préciser la manière dont ce projet a été mené.

### 10.1 Démarche de travail

1. **Conception initiale** : nous avons défini la hiérarchie des classes et rédigé une première version du code, en appliquant les principes vus en cours (abstraction, héritage, interfaces).
2. **Implémentation** : chaque membre a rédigé les fichiers dont il avait la charge (voir § 7).
3. **Relecture collective** : nous avons testé ensemble les scénarios et identifié les erreurs (méthode `afficherEmpruntesParLecteur` incomplète, duplication de méthodes, cas limites non gérés).
4. **Correction et amélioration** : nous avons utilisé des **outils d'intelligence artificielle** comme **assistants de relecture** pour nous aider à corriger les erreurs et à améliorer la qualité du code.
5. **Validation finale** : nous avons relu, compris et validé chaque correction avant de l'intégrer — aucune ligne n'a été acceptée sans compréhension.

### 10.2 Outils d'IA utilisés

| Outil | Usage principal |
|---|---|
| **Claude (Anthropic)** | Reformulation du cahier des charges, aide à la structuration de la problématique et de la solution, relecture critique du code. |
| **DeepSeek** | Reformulation complémentaire du cahier des charges, aide au débogage (méthode `afficherEmpruntesParLecteur`, duplications), suggestions d'amélioration du `Main`. |

### 10.3 Ce que l'IA a apporté

- **Détection d'erreurs** que nous n'avions pas vues (méthode dupliquée, `count` jamais incrémenté, absence de test `instanceof`).
- **Reformulation** du cahier des charges pour le rendre plus clair et plus argumentatif.
- **Suggestions de scénarios** de test supplémentaires (S5b, S5c, S5d, S8).

### 10.4 Ce que l'IA n'a **pas** fait

- Elle n'a **pas** remplacé notre réflexion : la conception générale, le choix des classes, la répartition du travail et la validation finale restent **entièrement les nôtres**.
- Elle n'a **pas** écrit le code à notre place : elle a signalé des erreurs et proposé des corrections que nous avons **comprises, discutées et validées**.

## 11. Livrables

1. Les **8 fichiers `.java`** compilables et exécutables.
2. Un **rapport** présentant la problématique, la solution et sa validation.
3. Une **démonstration** en ligne de commande.

---
