# 🎓 Gestion des Étudiants, Matières et Modules (UE)
Une application Java en console pour la gestion académique.

Ce projet Java est une application console permettant de gérer les étudiants, les matières et les unités d’enseignement (UE) dans un contexte académique. Il permet d'ajouter, modifier, supprimer et consulter les entités principales du système : les étudiants, les matières et les modules.
---

## 📚 Table des matières

- [🧾 Fonctionnalités principales](#-fonctionnalités-principales)
- [📦 Structure du Projet](#-structure-du-projet)
- [🚀 Comment exécuter le projet](#-comment-exécuter-le-projet)
- [🧪 Exemple d’utilisation](#-exemple-dutilisation)
- [💡 Remarques](#-remarques)
- [🔧 Améliorations futures](#-améliorations-futures)
---

## 🧾 Fonctionnalités principales

- **Gestion des Matières** :
  - Ajout, suppression, modification et recherche de matières.
  - Calcul de la note finale d’une matière à partir du DS et de l’examen.
  - Association de matières à des modules.

- **Gestion des Modules (UE)** :
  - Création de modules avec ajout ou suppression de matières.
  - Calcul de la moyenne d’un module basé sur les matières associées.

- **Gestion des Étudiants** :
  - Création, modification, suppression et recherche d’étudiants.
  - Association d’UE à des étudiants.
  - Affichage du bulletin de notes.
  - Détection du majeur de promotion.
  - Résultat final (Réussi / Échoué).
---

## 📦 Structure du Projet

Le projet est organisé en plusieurs classes Java :

- `Matiere.java` : représente une matière avec nom, coefficient, notes, etc.
- `UE.java` : représente une unité d’enseignement (module) contenant plusieurs matières.
- `Etudiant.java` : représente un étudiant et les modules qu’il suit.
- `GestionMatiere.java` : gestion centralisée des matières (ajout, suppression, etc.).
- `GestionUE.java` : gestion des modules (UE).
- `GestionEtudiants.java` : gestion des étudiants.
- `Menu.java` : interface principale via la console.
---

## 🚀 Comment exécuter le projet

1. **Pré-requis :**
   - Java JDK 8 ou supérieur installé.
   - Un IDE Java comme IntelliJ, Eclipse, NetBeans **ou** le terminal avec `javac`.

2. **Depuis un IDE :**

   - Ouvrir un nouveau projet.
   - Ajouter tous les fichiers .java dans le projet.
   - Exécuter la classe Menu.
---

## 🧪 Exemple d’utilisation
Au lancement de l’application, vous aurez un menu avec les options suivantes :
Bienvenue à notre plateforme :
1. Page matière
2. Page module (UE)
3. Page étudiant
0. Quitter
Chaque option donne accès à des sous-menus pour la gestion spécifique de cette entité.
---

## 💡 Remarques
   - Le système est basé sur des tableaux statiques (de taille 10). Pour passer à une solution plus évolutive, vous pouvez remplacer les tableaux par des collections dynamiques (ArrayList, HashMap, etc.).
   - La saisie est entièrement via la console (ligne de commande).
   - La vérification des saisies est basique, à améliorer pour plus de robustesse (e.g. gestion des exceptions).
   - Le projet est conçu pour une démonstration pédagogique, non pour une production.
---

## 🔧 Améliorations futures
   - Interface graphique (JavaFX ou Swing).
   - Persistance des données (fichiers, base de données).
   - Ajout d’un système d’authentification pour les enseignants/admins.